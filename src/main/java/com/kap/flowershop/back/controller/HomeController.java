package com.kap.flowershop.back.controller;

import com.kap.flowershop.back.service.CartService;
import com.kap.flowershop.back.service.CustomerOrderService;
import com.kap.flowershop.back.service.ProductService;
import com.kap.flowershop.back.service.UserService;
import com.kap.flowershop.back.entity.*;
import com.kap.flowershop.back.mapping.CartMapper;
import com.kap.flowershop.back.mapping.ProductMapper;
import com.kap.flowershop.back.session_util.SessionAttributes;
import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.back.session_util.CartItem;
import com.kap.flowershop.front.dto.CartDto;
import com.kap.flowershop.front.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(HttpSession httpSession) {
        log.info("Start point of app");
        ModelAndView modelAndView = new ModelAndView();
        if (httpSession.getAttribute("sessionAttributes") == null) {
            SessionAttributes sessionAttributes = new SessionAttributes();
            CartDto cart = new CartDto();
            UserDto user = new UserDto();
            sessionAttributes.setUser(user);
            sessionAttributes.setCart(cart);
            httpSession.setAttribute("sessionAttributes", sessionAttributes);
            httpSession.setAttribute("userName", null);
        }
        modelAndView.setViewName("general");
        return modelAndView;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView catalog(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if (((SessionAttributes) httpSession.getAttribute("sessionAttributes")).getUser().getUserId() == null) {
            modelAndView.setViewName("redirect:/login");
        } else {
            modelAndView.addObject("products", productService.getProductList().stream().map(p -> productMapper.entityToDto(p)).collect(Collectors.toList()));
            modelAndView.setViewName("catalog");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/search")
    public ModelAndView search(@RequestParam(value = "searchParam", required = false) String searchParam,
                               @RequestParam(value = "minParam", required = false) String minParam,
                               @RequestParam(value = "maxParam", required = false) String maxParam,
                               HttpSession httpSession) {
        log.info("Search param "+searchParam);
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = new ArrayList<>();

        if (searchParam.isEmpty() && minParam.isEmpty() && maxParam.isEmpty()) {
            modelAndView.addObject("products", productService.getProductList().stream().map(p -> productMapper.entityToDto(p)).collect(Collectors.toList()));
        } else {
            products.addAll(productService.searchProducts(searchParam, minParam, maxParam));
        }

        if (products.isEmpty()) {
            modelAndView.addObject("noResults", "The query " + searchParam + " " + minParam + " " + maxParam + " returned no results");
        } else {
            modelAndView.addObject("products", products.stream().map(p -> productMapper.entityToDto(p)).collect(Collectors.toList()));
            String responseString = "Results for ";
            responseString += !searchParam.isEmpty() ?  searchParam : "";
            responseString += !minParam.isEmpty() ? " minPrice " + minParam : "";
            responseString += !maxParam.isEmpty() ? " maxPrice " + maxParam : "";
            modelAndView.addObject("results", responseString);
        }

        modelAndView.setViewName("search");
        return modelAndView;
    }

    @RequestMapping(value = "/error")
    public ModelAndView error() {
        return new ModelAndView("error");
    }

    @RequestMapping(value = "/get_quantity_in_cart", method = RequestMethod.POST)
    @ResponseBody
    public String checkQtyInCart(HttpServletRequest request, HttpSession httpSession) {
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        String productId = request.getParameter("productId");
        CartDto cartDto = sessionAttributes.getCart();
        CartItem cartItem = null;
        if (Objects.nonNull(cartDto.getCartItems())) {
            cartItem = cartDto.getCartItems().stream()
                    .filter(item -> item.getProductId().equals(productId))
                    .findFirst().orElse(null);
        }
        return Objects.nonNull(cartItem) ? String.valueOf(cartItem.getQuantity()) : String.valueOf(0);
    }

    @RequestMapping(value = "/buy")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCartItem(HttpServletRequest request, HttpSession httpSession) {
        String productId = request.getParameter("productId");
        String productQty = request.getParameter("productQty");
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        log.info("Customer : " + sessionAttributes.getUser().getUserId() + " "+ sessionAttributes.getUser().getUserName());
        Cart cart = cartService.addItemToCart(cartMapper.dtoToEntity(sessionAttributes.getCart()), productId, productQty);
        sessionAttributes.setCart(cartMapper.entityToDto(cart));
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
    }

}

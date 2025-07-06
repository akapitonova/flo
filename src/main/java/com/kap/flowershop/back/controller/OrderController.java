package com.kap.flowershop.back.controller;

import com.kap.flowershop.back.service.CustomerOrderService;
import com.kap.flowershop.back.service.UserService;
import com.kap.flowershop.back.mapping.CartMapper;
import com.kap.flowershop.back.mapping.CustomerOrderMapper;
import com.kap.flowershop.back.mapping.UserMapper;
import com.kap.flowershop.front.dto.CartDto;
import com.kap.flowershop.back.entity.CustomerOrder;
import com.kap.flowershop.back.session_util.SessionAttributes;
import com.kap.flowershop.back.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/order")
    public String createOrder(HttpSession httpSession, Model model) {
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        Users user = userService.getUserByUsername(sessionAttributes.getUser().getUserName());
        CustomerOrder customerOrder = customerOrderService.createCustomerAndAddOrder(cartMapper.dtoToEntity(sessionAttributes.getCart()), user.getUserName());
        sessionAttributes.setCart(new CartDto());
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
        model.addAttribute("user", userMapper.entityToDto(user));
        model.addAttribute("order", customerOrderMapper.entityToDto(customerOrder));
        if(Objects.nonNull(user.getUserProperties().getDiscount())) {
            BigDecimal discountSumm = calculateDiscountSum(customerOrder, user.getUserProperties().getDiscount());
            model.addAttribute("totalDiscount", discountSumm);
        } else {
            model.addAttribute("totalDiscount", customerOrder.getTotal());
        }

        return "/order";
    }

    @RequestMapping("/order/{orderId}")
    public String getOrder(@PathVariable(value = "orderId") String orderId, HttpSession httpSession, Model model) {
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        Users user = userService.getUserByUsername(sessionAttributes.getUser().getUserName());
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(orderId);
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
        model.addAttribute("user", userMapper.entityToDto(user));
        model.addAttribute("order", customerOrderMapper.entityToDto(customerOrder));
        if(Objects.nonNull(user.getUserProperties().getDiscount())) {
            BigDecimal discountSumm = calculateDiscountSum(customerOrder, user.getUserProperties().getDiscount());
            model.addAttribute("totalDiscount", discountSumm);
        } else {
            model.addAttribute("totalDiscount", customerOrder.getTotal());
        }

        return "/order";
    }

    @RequestMapping("/order/pay/{orderId}")
    public String payOrder(@PathVariable(value = "orderId") String orderId, Model model, HttpSession httpSession) {
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        Users user = userService.getUserByUsername(sessionAttributes.getUser().getUserName());
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(orderId);
        BigDecimal newBalance = new BigDecimal(0);
        if(Objects.nonNull(user.getUserProperties().getDiscount())) {
            BigDecimal discountSumm = calculateDiscountSum(customerOrder, user.getUserProperties().getDiscount());
            newBalance = user.getUserProperties().getBalance().subtract(discountSumm);
            user.getUserProperties().setDiscount(null);
        } else {
            newBalance = user.getUserProperties().getBalance().subtract(customerOrder.getTotal());
        }
        user.getUserProperties().setBalance(newBalance);
        customerOrderService.payCustomerOrder(orderId);
        userService.updateUser(user);
        sessionAttributes.setUser(userMapper.entityToDto(user));
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
        model.addAttribute("payOrderSuccess", "Your order payed successfully");

        return "redirect:/catalog";
    }

    @RequestMapping("/order/cancel/{orderId}")
    public String cancelOrder(@PathVariable(value = "orderId") String orderId, Model model, HttpSession httpSession) {
        customerOrderService.cancelOrder(orderId);
        log.info("Order "+orderId+" canceled successfully");
        return "redirect:/catalog";
    }

    private BigDecimal calculateDiscountSum(CustomerOrder customerOrder, BigDecimal discount) {
        return customerOrder.getTotal().subtract(customerOrder.getTotal().divide(new BigDecimal(100)).multiply(discount));
    }
}

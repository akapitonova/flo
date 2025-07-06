package com.kap.flowershop.back.controller;

import com.kap.flowershop.back.mapping.CustomerOrderMapper;
import com.kap.flowershop.back.service.CustomerOrderService;
import com.kap.flowershop.back.service.UserMarshallingService;
import com.kap.flowershop.back.service.UserService;
import com.kap.flowershop.back.entity.CustomerOrder;
import com.kap.flowershop.back.mapping.UserMapper;
import com.kap.flowershop.back.session_util.SessionAttributes;
import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.front.dto.CartDto;
import com.kap.flowershop.front.dto.UserDto;
import com.kap.flowershop.front.enums.Role;
import com.kap.flowershop.front.jms.DiscountObject;
import com.kap.flowershop.front.jms.Producer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private UserMarshallingService userMarshallingService;

    @Autowired
    private Producer producer;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null)
            model.addAttribute("error", "Invalid username and Password");
        if (logout != null)
            model.addAttribute("logout", "You have logged out successfully");
        return "login";
    }

    @RequestMapping(value = "/login_process", method = RequestMethod.POST)
    public String login_process(@RequestParam(value = "j_username", required = false) String username,
                                @RequestParam(value = "j_password", required = false) String pass,
                                HttpSession httpSession,
                                HttpServletRequest request) {
        Users user = userService.getUserByUsername(username);

        if (user == null || !user.getPassword().equals(pass)) {
            request.setAttribute("error", "Invalid login or password");
            return "login";
        }

        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        sessionAttributes.setUser(userMapper.entityToDto(user));
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
        httpSession.setAttribute("userName", user.getUserName());
        log.info("User "+username+" login successfully");

        return Role.ADMIN.equals(user.getRole()) ? "redirect:/admin" : "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession, HttpServletRequest request) {
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        log.info("User "+sessionAttributes.getUser().getUserId()+" logout process");
        sessionAttributes.setUser(new UserDto());
        sessionAttributes.setCart(new CartDto());
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
        httpSession.removeAttribute("userName");

        request.setAttribute("logout", "You log out.");

        return "login";
    }

    @RequestMapping(value = "/register")
    public ModelAndView getRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return new ModelAndView("register", model.asMap());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute(value = "user") UserDto userdto, Model model,
                                   BindingResult result) throws IOException {
        if (result.hasErrors())
            return "redirect:/register";
        Users user = userMapper.dtoToEntity(userdto);
        userService.addUser(user);
        userMarshallingService.convertFromObjectToXML(user, user.getUserName());
        DiscountObject requestObject = new DiscountObject(user.getUserId(),4);
        try {
            producer.sendMessage(userMarshallingService.convertFromObjectToString(requestObject));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        log.info("Added user " + user.getUserId() + " " + user.getUserName());
        model.addAttribute("registrationSuccess", "Registered Successfully. Login using username and password");
        return "redirect:/login";
    }

    @RequestMapping(value = "/check_user", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkUser(@RequestParam(value = "username") String username) {
        Users user = userService.getUserByUsername(username);
        return Objects.nonNull(user);
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public ModelAndView userInfo(HttpSession httpSession, Model model) {
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        UserDto user = sessionAttributes.getUser();
        List<CustomerOrder> orders = customerOrderService.getCustomerOrdersForUser(user.getUserId());

        model.addAttribute("user", user);
        model.addAttribute("orders", customerOrderMapper.toListDto(orders));
        return new ModelAndView("userinfo", model.asMap());
    }

    @RequestMapping(value = "/change_user_info", method = RequestMethod.POST)
    public String changeUserInfo(@Valid @ModelAttribute(value = "user") UserDto userDto, Model model,
                                   BindingResult result, HttpSession httpSession) {
        if (result.hasErrors())
            return "redirect:/userinfo";
        SessionAttributes sessionAttributes = (SessionAttributes) httpSession.getAttribute("sessionAttributes");
        Users user = userService.updateUserInfo(sessionAttributes.getUser().getUserName(), userDto);
        sessionAttributes.setUser(userMapper.entityToDto(user));
        httpSession.setAttribute("sessionAttributes", sessionAttributes);
        return "redirect:/catalog";
    }
}

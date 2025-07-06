package com.kap.flowershop.back.controller;

import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.back.mapping.CustomerOrderMapper;
import com.kap.flowershop.back.mapping.UserMapper;
import com.kap.flowershop.back.service.CustomerOrderService;
import com.kap.flowershop.back.service.UserService;
import com.kap.flowershop.front.dto.CustomerOrderDto;
import com.kap.flowershop.front.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Api(description="admin controller")
@Slf4j
@Controller
public class AdminController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @ApiOperation(value = "get admin page", httpMethod = "GET")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        List<CustomerOrderDto> customerOrderDtoList = customerOrderMapper.toListDto(customerOrderService.getCustomerOrders());
        List<UserDto> userDtoList = userMapper.toListDto(userService.getAllUsers());
        modelAndView.addObject("orders", customerOrderDtoList);
        modelAndView.addObject("users", userDtoList);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @ApiOperation(value = "close payed order by admin", httpMethod = "POST")
    @RequestMapping("/admin/closeOrder/{orderId}")
    public ModelAndView closeOrder(@PathVariable(value = "orderId") String orderId) {
        customerOrderService.closeCustomerOrder(orderId);
        log.info("Order "+orderId+" closed successfully");
        return new ModelAndView("redirect:/admin");
    }

    @ApiOperation(value = "add money for user by admin", httpMethod = "GET")
    @RequestMapping(value = "/admin/addMoney/{userId}", method = RequestMethod.GET)
    public ModelAndView addMoney(@PathVariable(value = "userId") String userId) {
        Users user = userService.getUserById(userId);
        UserDto userDto = userMapper.entityToDto(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userDto);
        modelAndView.setViewName("addmoney");
        return modelAndView;
    }

    @ApiOperation(value = "post request for addMoney operation", httpMethod = "POST")
    @RequestMapping(value = "/addmoney_process", method = RequestMethod.POST)
    public String addmoney_process(@RequestParam(value = "j_username") String username,
                                   @RequestParam(value = "j_summ", required = false) BigDecimal summ) {
        userService.updateUserBalance(username, summ);
        return "redirect:/admin";
    }
}

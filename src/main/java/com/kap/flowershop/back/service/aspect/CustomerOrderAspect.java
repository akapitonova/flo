package com.kap.flowershop.back.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class CustomerOrderAspect {

    @Before("execution(public * com.kap.flowershop.back.service.CustomerOrderServiceImpl.createCustomerAndAddOrder(..))")
    public void beforeCallAtMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("Добавление заказа...");
        log.debug("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("execution(public * com.kap.flowershop.back.service.CustomerOrderServiceImpl.createCustomerAndAddOrder(..))")
    public void afterCallAt(JoinPoint jp) {
        log.debug("after " + jp.toString());
        log.info("Добавление заказа успешно завершено");
    }
}

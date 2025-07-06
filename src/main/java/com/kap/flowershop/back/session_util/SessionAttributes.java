package com.kap.flowershop.back.session_util;

import com.kap.flowershop.front.dto.CartDto;
import com.kap.flowershop.front.dto.UserDto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SessionAttributes {
    private CartDto cart;
    private UserDto user;
}

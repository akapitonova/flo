package com.kap.flowershop.front.dto;

import com.kap.flowershop.front.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = -9135693352701600497L;

    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String customerPhone;
    private String shippingAddress;
    private Role role;
    private BigDecimal balance;
    private BigDecimal discount;
    private String password;

}

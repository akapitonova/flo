package com.kap.flowershop.back.entity_props;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserProperties implements Serializable {

    private String firstName;

    private String lastName;

    private String customerPhone;

    private String shippingAddress;

    private BigDecimal balance;

    private BigDecimal discount;
}

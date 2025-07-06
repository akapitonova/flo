package com.kap.flowershop.front.dto;

import com.kap.flowershop.front.enums.Status;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CustomerOrderDto implements Serializable {
    private static final long serialVersionUID = 6905592531845858981L;

    private String customerOrderId;
    private Status status;
    private BigDecimal total;
    private Date openDate;
    private Date closeDate;
    private UserDto user;
    private List<OrderItemDto> orderItems;

}

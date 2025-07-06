package com.kap.flowershop.front.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderItemDto implements Serializable {
    private static final long serialVersionUID = -3863690753226937225L;

    private String orderItemId;
    private int quantity;
    private BigDecimal price;
    private String productName;
    private String productid;
}

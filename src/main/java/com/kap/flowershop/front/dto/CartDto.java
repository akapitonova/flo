package com.kap.flowershop.front.dto;

import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.back.session_util.CartItem;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDto implements Serializable {
    private static final long serialVersionUID = -3944873383940140866L;

    private String cartId;
    private List<CartItem> cartItems;
    private BigDecimal totalPrice;

}

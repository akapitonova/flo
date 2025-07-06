package com.kap.flowershop.back.session_util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Component
public class CartItem implements Serializable {

	private static final long serialVersionUID = -2455760938054036364L;

	private String cartItemId;
	private String cartId;
	private int quantity;
	private BigDecimal price;
	private String productId;
	private String productName;
	private String productPhoto;
}

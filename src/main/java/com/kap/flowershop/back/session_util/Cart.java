package com.kap.flowershop.back.session_util;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Component
public class Cart implements Serializable {

	private static final long serialVersionUID = 8436097833452420298L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cartId;
	private List<CartItem> cartItems;
	private BigDecimal totalPrice;

}

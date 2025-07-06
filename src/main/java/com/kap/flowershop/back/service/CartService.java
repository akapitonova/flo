package com.kap.flowershop.back.service;

import com.kap.flowershop.back.session_util.Cart;

public interface CartService {
    Cart addItemToCart(Cart cart, String productId, String productQty);
}

package com.kap.flowershop.back.service;

import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.back.session_util.CartItem;
import com.kap.flowershop.back.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductService productService;

    public Cart addItemToCart(Cart cart, String productId, String productQty) {
        Product product = productService.findProduct(productId);
        if(Objects.isNull(cart)) {
            cart = new Cart();
        }
        log.info("Cart : "+cart.getCartId());
        List<CartItem> cartItems = new ArrayList<CartItem>();
        CartItem cartItem = new CartItem();
        if (Objects.nonNull(cart.getCartItems())) {
            cartItems = cart.getCartItems();
            cartItem = cartItems.stream()
                    .filter(item -> item.getProductId().equals(product.getProductId()))
                    .findFirst().orElse(null);
        }
        if (Objects.nonNull(cartItem) && Objects.nonNull(cartItem.getProductId())) {
            cartItem.setQuantity(cartItem.getQuantity() + Integer.parseInt(productQty));
            cart.getCartItems().set(cart.getCartItems().indexOf(cartItem), cartItem);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(Integer.parseInt(productQty));
            cartItem.setProductId(product.getProductId());
            cartItem.setProductName(product.getName());
            cartItem.setPrice(product.getPrice());
            cartItem.setProductPhoto(product.getPhoto());
            cartItem.setCartItemId(cart.getCartId());
            cartItems.add(cartItem);
            cart.setCartItems(cartItems);
        }
        BigDecimal totalPrice = new BigDecimal(0);
        for(CartItem item : cartItems) {
            totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        cart.setTotalPrice(totalPrice);

        return cart;
    }
}

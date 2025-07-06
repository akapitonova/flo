package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.back.session_util.CartItem;
import com.kap.flowershop.front.dto.CartDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T21:32:09+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto entityToDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setCartId( cart.getCartId() );
        List<CartItem> list = cart.getCartItems();
        if ( list != null ) {
            cartDto.setCartItems( new ArrayList<CartItem>( list ) );
        }
        cartDto.setTotalPrice( cart.getTotalPrice() );

        return cartDto;
    }

    @Override
    public Cart dtoToEntity(CartDto cart) {
        if ( cart == null ) {
            return null;
        }

        Cart cart1 = new Cart();

        cart1.setCartId( cart.getCartId() );
        List<CartItem> list = cart.getCartItems();
        if ( list != null ) {
            cart1.setCartItems( new ArrayList<CartItem>( list ) );
        }
        cart1.setTotalPrice( cart.getTotalPrice() );

        return cart1;
    }
}

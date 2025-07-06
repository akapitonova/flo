package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.front.dto.CartDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDto entityToDto(Cart cart);

    Cart dtoToEntity(CartDto cart);
}

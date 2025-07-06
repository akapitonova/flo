package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.OrderItem;
import com.kap.flowershop.front.dto.OrderItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto entityToDto(OrderItem orderItem);

    OrderItem dtoToEntity(OrderItemDto orderItem);
}

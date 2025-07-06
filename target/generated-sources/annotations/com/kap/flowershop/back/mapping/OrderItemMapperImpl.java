package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.OrderItem;
import com.kap.flowershop.front.dto.OrderItemDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T21:32:08+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemDto entityToDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        if ( orderItem.getOrderItemId() != null ) {
            orderItemDto.setOrderItemId( String.valueOf( orderItem.getOrderItemId() ) );
        }
        orderItemDto.setQuantity( orderItem.getQuantity() );
        orderItemDto.setPrice( orderItem.getPrice() );
        orderItemDto.setProductName( orderItem.getProductName() );
        orderItemDto.setProductid( orderItem.getProductid() );

        return orderItemDto;
    }

    @Override
    public OrderItem dtoToEntity(OrderItemDto orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItem orderItem1 = new OrderItem();

        if ( orderItem.getOrderItemId() != null ) {
            orderItem1.setOrderItemId( Long.parseLong( orderItem.getOrderItemId() ) );
        }
        orderItem1.setQuantity( orderItem.getQuantity() );
        orderItem1.setPrice( orderItem.getPrice() );
        orderItem1.setProductName( orderItem.getProductName() );
        orderItem1.setProductid( orderItem.getProductid() );

        return orderItem1;
    }
}

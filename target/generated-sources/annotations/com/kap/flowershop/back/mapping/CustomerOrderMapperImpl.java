package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.CustomerOrder;
import com.kap.flowershop.back.entity.OrderItem;
import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.front.dto.CustomerOrderDto;
import com.kap.flowershop.front.dto.OrderItemDto;
import com.kap.flowershop.front.dto.UserDto;
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
public class CustomerOrderMapperImpl implements CustomerOrderMapper {

    @Override
    public CustomerOrderDto entityToDto(CustomerOrder customerOrder) {
        if ( customerOrder == null ) {
            return null;
        }

        CustomerOrderDto customerOrderDto = new CustomerOrderDto();

        customerOrderDto.setCustomerOrderId( customerOrder.getCustomerOrderId() );
        customerOrderDto.setStatus( customerOrder.getStatus() );
        customerOrderDto.setTotal( customerOrder.getTotal() );
        customerOrderDto.setOpenDate( customerOrder.getOpenDate() );
        customerOrderDto.setCloseDate( customerOrder.getCloseDate() );
        customerOrderDto.setUser( usersToUserDto( customerOrder.getUser() ) );
        customerOrderDto.setOrderItems( orderItemListToOrderItemDtoList( customerOrder.getOrderItems() ) );

        return customerOrderDto;
    }

    @Override
    public List<CustomerOrderDto> toListDto(List<CustomerOrder> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerOrderDto> list1 = new ArrayList<CustomerOrderDto>( list.size() );
        for ( CustomerOrder customerOrder : list ) {
            list1.add( entityToDto( customerOrder ) );
        }

        return list1;
    }

    protected UserDto usersToUserDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( users.getUserId() != null ) {
            userDto.setUserId( String.valueOf( users.getUserId() ) );
        }
        userDto.setUserName( users.getUserName() );
        userDto.setRole( users.getRole() );
        userDto.setPassword( users.getPassword() );

        return userDto;
    }

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
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

    protected List<OrderItemDto> orderItemListToOrderItemDtoList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemDto> list1 = new ArrayList<OrderItemDto>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list1;
    }
}

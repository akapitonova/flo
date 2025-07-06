package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.CustomerOrder;
import com.kap.flowershop.front.dto.CustomerOrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

    CustomerOrderDto entityToDto(CustomerOrder customerOrder);

    List<CustomerOrderDto> toListDto(List<CustomerOrder> list);
}

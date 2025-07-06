package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.Product;
import com.kap.flowershop.front.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto entityToDto(Product product);
}

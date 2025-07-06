package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.Product;
import com.kap.flowershop.front.dto.ProductDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T21:32:09+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto entityToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( product.getProductId() );
        productDto.setName( product.getName() );
        productDto.setPhoto( product.getPhoto() );
        if ( product.getPrice() != null ) {
            productDto.setPrice( product.getPrice().doubleValue() );
        }
        productDto.setStoreqty( product.getStoreqty() );

        return productDto;
    }
}

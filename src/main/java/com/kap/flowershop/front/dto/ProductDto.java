package com.kap.flowershop.front.dto;

import com.kap.flowershop.back.entity.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 7573997245512866475L;

    private String productId;
    private String name;
    private String photo;
    private Double price;
    private int storeqty;

}

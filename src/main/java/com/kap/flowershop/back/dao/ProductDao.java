package com.kap.flowershop.back.dao;

import com.kap.flowershop.back.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> searchProducts(String name, String minPrice, String maxPrice);
}

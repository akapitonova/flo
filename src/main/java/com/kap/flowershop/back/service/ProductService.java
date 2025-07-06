package com.kap.flowershop.back.service;

import com.kap.flowershop.back.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();
    List<Product> searchProducts(String name, String minPrice, String maxPrice);
    Product findProduct(String productId);
    void increaseStockSize(int count);
}

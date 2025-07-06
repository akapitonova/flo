package com.kap.flowershop.back.service;

import com.kap.flowershop.back.dao.ProductDao;
import com.kap.flowershop.back.entity.Product;
import com.kap.flowershop.back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProducts(String name, String minPrice, String maxPrice) {
        return productDao.searchProducts(name, minPrice, maxPrice);
    }

    @Override
    public Product findProduct(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    @Transactional
    public void increaseStockSize(int count) {
        List<Product> products = getProductList();
        for(Product product : products) {
            product.setStoreqty(product.getStoreqty()+count);
        }
        productRepository.saveAll(products);
    }
}

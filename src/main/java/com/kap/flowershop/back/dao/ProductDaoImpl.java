package com.kap.flowershop.back.dao;

import com.kap.flowershop.back.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager em;

    public List<Product> searchProducts(String name, String minPrice, String maxPrice) {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT t FROM " + Product.class.getName() + " t WHERE t.name LIKE :name AND t.price >= :minPrice" +
                " AND t.price <= :maxPrice";
        if (minPrice.isEmpty()) {
            minPrice = "0";
        }
        if (maxPrice.isEmpty()) {
            maxPrice = em.createQuery("SELECT MAX(t.price) FROM " + Product.class.getName() +" t").getSingleResult().toString();
        }
        productList = em.createQuery(query)
                .setParameter("name", "%"+name+"%")
                .setParameter("minPrice", new BigDecimal(minPrice))
                .setParameter("maxPrice", new BigDecimal(maxPrice))
                .getResultList();
        return productList;
    }
}

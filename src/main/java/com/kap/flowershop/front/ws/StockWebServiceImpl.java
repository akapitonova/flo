package com.kap.flowershop.front.ws;

import com.kap.flowershop.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

@WebService(endpointInterface = "com.kap.flowershop.front.ws.StockWebService")
public class StockWebServiceImpl implements StockWebService {
/*    @Override
    public void increaseStockSize(int count) {

    }*/
    @Autowired
    private ProductService productService;
    @Override
    public void increaseStockSize(int count) {
        productService.increaseStockSize(count);
    }
}

package com.kap.flowershop.back.service;

import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.back.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	CustomerOrder createCustomerAndAddOrder(Cart cart, String userName);
	void closeCustomerOrder(String orderId);
	List<CustomerOrder> getCustomerOrders();
	CustomerOrder getCustomerOrderById(String orderId);
	void payCustomerOrder(String orderId);
	List<CustomerOrder> getCustomerOrdersForUser(String userId);
    void cancelOrder(String orderId);
}

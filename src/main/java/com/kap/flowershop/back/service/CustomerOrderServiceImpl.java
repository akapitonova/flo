package com.kap.flowershop.back.service;

import com.kap.flowershop.back.entity.CustomerOrder;
import com.kap.flowershop.back.entity.OrderItem;
import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.back.repository.CustomerOrderRepository;
import com.kap.flowershop.back.session_util.Cart;
import com.kap.flowershop.back.session_util.CartItem;
import com.kap.flowershop.front.enums.Status;
import jersey.repackaged.com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;

	@Autowired
	private UserService userService;

	@Retryable(value = SQLException.class, maxAttempts = 2)
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderRepository.save(customerOrder);
	}

	public CustomerOrder createCustomerAndAddOrder(Cart cart, String userName) {
		Users user = userService.getUserByUsername(userName);
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setUser(user);
		customerOrder.setStatus(Status.CREATED);
		customerOrder.setOpenDate(new Date());
		customerOrder.setTotal(cart.getTotalPrice());
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProductid(cartItem.getProductId());
			orderItem.setProductName(cartItem.getProductName());
			orderItem.setPrice(cartItem.getPrice());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setCustomerOrder(customerOrder);
			orderItems.add(orderItem);
		}
		customerOrder.setOrderItems(orderItems);
		addCustomerOrder(customerOrder);
		return customerOrder;
	}

	public List<CustomerOrder> getCustomerOrders() {
		List<CustomerOrder> customerOrders = new ArrayList<>();
		try{
			customerOrders = customerOrderRepository.getCustomerOrders(Sets.newHashSet(Status.CREATED, Status.PAYED));
		} catch (Exception e) {
			log.error("Get customer orders throw some error: " + e);
		}
		return customerOrders;
	}

	@Async("threadPoolTaskExecutor")
	@Transactional
	public void closeCustomerOrder(String orderId) {
		CustomerOrder order = getCustomerOrderById(orderId);
		order.setStatus(Status.CLOSED);
		order.setCloseDate(new Date());
		customerOrderRepository.save(order);
	}

	public CustomerOrder getCustomerOrderById(String orderId) {
		return customerOrderRepository.findById(orderId).orElse(null);
	}

	@Transactional
	public void payCustomerOrder(String orderId) {
		CustomerOrder order = getCustomerOrderById(orderId);
		order.setStatus(Status.PAYED);
		customerOrderRepository.save(order);
	}

	@Transactional
	public List<CustomerOrder> getCustomerOrdersForUser(String userId) {
		List<CustomerOrder> customerOrders = new ArrayList<>();
		try {
			customerOrders = customerOrderRepository.getCustomerOrdersForUser(Status.CREATED, Long.parseLong(userId));
		} catch (Exception e) {
			log.error("Get customer orders for user " + userId + " throw some error: " + e);
		}
		return customerOrders;
	}

	@Transactional
	public void cancelOrder(String orderId) {
		CustomerOrder order = getCustomerOrderById(orderId);
		order.setStatus(Status.CANCELED);
		order.setCloseDate(new Date());
		customerOrderRepository.save(order);
	}
}

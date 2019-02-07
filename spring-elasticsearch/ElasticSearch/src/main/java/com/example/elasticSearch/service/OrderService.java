package com.example.elasticSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elasticSearch.manager.OrderManager;

@Service
public class OrderService {

	@Autowired
	private OrderManager manager;

	public void getNumberOfOrder() {
		System.out.println(manager.countOrder());
	}
	public void getOrderById() {
		System.out.println(manager.getOrderbyId());
		System.out.println(manager.getOrders());
	}
	
	
	public OrderManager getManager() {
		return manager;
	}

	public void setManager(OrderManager manager) {
		this.manager = manager;
	}
}

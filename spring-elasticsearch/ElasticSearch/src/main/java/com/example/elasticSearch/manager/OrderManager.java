package com.example.elasticSearch.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.example.elasticSearch.model.Order;
import com.example.elasticSearch.repository.OrderRepository;

@Component
public class OrderManager {

	@Autowired
	private ElasticsearchTemplate template;
	
	@Autowired
	private OrderRepository repository;

	public long countOrder() {
		return repository.count();
	}
	
	public Order getOrderbyId() {
		return repository.findById(2l).get();
	}
	
	public List<Order> getOrders(){
		return repository.findByStatus("completed");
	}
	public ElasticsearchTemplate getTemplate() {
		return template;
	}

	public void setTemplate(ElasticsearchTemplate template) {
		this.template = template;
	}

	public OrderRepository getRepository() {
		return repository;
	}

	public void setRepository(OrderRepository repository) {
		this.repository = repository;
	}
	
	
}

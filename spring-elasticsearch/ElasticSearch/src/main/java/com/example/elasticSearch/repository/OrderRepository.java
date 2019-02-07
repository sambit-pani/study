package com.example.elasticSearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.elasticSearch.model.Order;

@Repository
public interface OrderRepository extends ElasticsearchCrudRepository<Order, Long>{

	public List<Order> findByStatus(String status);
}

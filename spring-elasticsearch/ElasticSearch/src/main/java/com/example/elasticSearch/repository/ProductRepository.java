package com.example.elasticSearch.repository;


import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.elasticSearch.model.Product;

@Repository
public interface ProductRepository extends ElasticsearchCrudRepository<Product, Long>{

	List<Product> findByName(String name);
	
}

package com.example.elasticSearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.example.elasticSearch.model.User;

public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {

}

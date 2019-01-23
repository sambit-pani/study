package com.example.rest.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.webservice.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer>{

}

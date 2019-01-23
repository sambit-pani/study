package com.sambit.study.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.sambit.study.springboot.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

}

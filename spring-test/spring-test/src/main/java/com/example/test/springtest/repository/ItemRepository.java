package com.example.test.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.springtest.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}

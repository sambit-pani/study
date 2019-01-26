package com.example.test.springtest.service;

import org.springframework.stereotype.Component;

import com.example.test.springtest.model.Item;

@Component
public class ItemService {

	public Item getItem() {
		return new Item(1, "apple", 12, 50);
	}

}

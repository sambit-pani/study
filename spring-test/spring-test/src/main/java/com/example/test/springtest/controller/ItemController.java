package com.example.test.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.springtest.model.Item;

@RestController
public class ItemController {

	@GetMapping("/item")
	public Item getItem() {
		return new Item(1, "apple", 12, 10);
	}
}

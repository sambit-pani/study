package com.example.test.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.springtest.model.Item;
import com.example.test.springtest.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService service;
	
	@GetMapping("/item")
	public Item getItem() {
		return new Item(1, "apple", 12, 10);
	}
	
	@GetMapping("/item-service")
	public Item getItemFromService() {
		return service.getItem();
	}
	
	@GetMapping("/all-item")
	public List<Item> getAllItems(){
		return service.getAllItems();
	}
}

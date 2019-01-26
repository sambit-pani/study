package com.example.test.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.test.springtest.model.Item;
import com.example.test.springtest.repository.ItemRepository;

@Component
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	public Item getItem() {
		return new Item(1, "apple", 12, 50);
	}
	
	public List<Item> getAllItems(){
		List<Item> itemList = itemRepo.findAll();
		for(Item item:itemList) {
			item.setValue(item.getQuantity()*item.getPrice());
		}
		return itemList;
	}

}

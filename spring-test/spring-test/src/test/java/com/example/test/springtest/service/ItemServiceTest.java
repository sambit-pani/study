package com.example.test.springtest.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.test.springtest.model.Item;
import com.example.test.springtest.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	@Mock
	private ItemRepository itemRepo;
	
	@InjectMocks
	private ItemService service = new ItemService();

	@Test
	public void testGetAllItems() {
		Mockito.when(itemRepo.findAll())
				.thenReturn(Arrays.asList(new Item(1, "apple", 10, 20), new Item(2, "orange", 11, 22)));
		List<Item> items = service.getAllItems();
		Mockito.verify(itemRepo,Mockito.atLeastOnce()).findAll();
		assertEquals(200, items.get(0).getValue(),0.01);
		assertEquals(242, items.get(1).getValue(),0.01);
		
	}

}

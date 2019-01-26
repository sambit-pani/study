package com.example.test.springtest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.test.springtest.model.Item;
import com.example.test.springtest.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private ItemService itemService;

	@Test
	// json can ignore missing property also
	public void testGetItem() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content()
						.json("{\"id\":1,\"name\":\"apple\",\"price\":12.0,\"quantity\":10}"));
	}

	@Test
	public void testGetItemFromService() throws Exception {
		Mockito.when(itemService.getItem()).thenReturn(new Item(1, "apple", 95, 48));
		
		mock.perform(MockMvcRequestBuilders.get("/item-service").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{id:1,name:apple}"));
	}
}

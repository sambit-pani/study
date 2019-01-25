package com.example.test.springtest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.test.springtest.dao.DataService;

public class BusinessServiceStubTest {

	@Test
	public void testCalculateData() {
		BusinessService service = new BusinessService();
		service.setDataService(new DataServiceStubImpl());
		int result = service.calculateData();
		assertEquals(63, result);
		
	}
	
	@Test
	public void testCalculateData_empty() {
		BusinessService service = new BusinessService();
		service.setDataService(new DataService() {
			@Override
			public int[] getData() {
				return new int[] {};
			}
		});
		int result = service.calculateData();
		assertEquals(0, result);
	}
	@Test
	public void testCalculateData_oneValue() {
		BusinessService service = new BusinessService();
		service.setDataService(new DataService() {
			@Override
			public int[] getData() {
				return new int[] {4};
			}
		});
		int result = service.calculateData();
		assertEquals(4, result);
	}
}
class DataServiceStubImpl implements DataService{

	@Override
	public int[] getData() {
		return new int[]{1,5,123,63};
	}
	
}

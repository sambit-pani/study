package com.example.test.springtest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.example.test.springtest.dao.DataService;

public class BusinessServiceMockTest {

	private BusinessService service;
	private DataService dataService;
	
	@Before
	public void setUp() {
		service = new BusinessService();
		dataService = mock(DataService.class);
		service.setDataService(dataService);
	}
	@Test
	public void testCalculateData() {
		when(dataService.getData()).thenReturn(new int[] {1,2,3});
		int result = service.calculateData();
		assertEquals(6, result);
		
	}
	@Test
	public void testCalculateData_emptyData() {
		when(dataService.getData()).thenReturn(new int[] {});
		assertEquals(0, service.calculateData());
	}
	
	@Test
	public void testCalculateData_singleValue() {
		when(dataService.getData()).thenReturn(new int[] {1});
		assertEquals(1, service.calculateData());
	}
}
	

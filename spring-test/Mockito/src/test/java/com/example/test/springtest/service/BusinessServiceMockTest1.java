package com.example.test.springtest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.test.springtest.dao.DataService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockTest1 {

	@InjectMocks
	private BusinessService service= new BusinessService();
	
	@Mock
	private DataService dataService;
	
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
	

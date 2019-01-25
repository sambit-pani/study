package com.example.test.springtest.service;

import com.example.test.springtest.dao.DataService;

public class BusinessService {

	private DataService dataService;
	
	public int calculateData() {
		int sum=0;
		int[] data = dataService.getData();
		for(int i:data) {
			sum +=  i;
		}
		return sum;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
}

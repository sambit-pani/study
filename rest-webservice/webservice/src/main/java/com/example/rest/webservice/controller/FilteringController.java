package com.example.rest.webservice.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.webservice.model.FilteringEntity;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public MappingJacksonValue filter() {
		FilteringEntity entity = new FilteringEntity("prop1", "prop2", "prop3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("prop3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
		MappingJacksonValue value = new MappingJacksonValue(entity);
		
		value.setFilters(filters);
		return value;
	}
}

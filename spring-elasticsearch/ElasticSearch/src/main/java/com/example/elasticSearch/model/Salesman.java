package com.example.elasticSearch.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Salesman implements Serializable{

	@Field(type=FieldType.Integer)
	private int id;
	
	@Field(type=FieldType.Text)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Salesman(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Salesman() {}
}

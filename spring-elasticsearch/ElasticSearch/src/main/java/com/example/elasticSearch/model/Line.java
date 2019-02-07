package com.example.elasticSearch.model;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Line implements Serializable{
	
	@Field(type=FieldType.Double)
	private Double amount;
	
	@Field(type=FieldType.Integer)
	private Integer product_id;
	
	//@Field(type=FieldType.Auto)
	private Short quantity;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Short getQuantity() {
		return quantity;
	}

	public void setQuantity(Short quantity) {
		this.quantity = quantity;
	}
	
	
	
}

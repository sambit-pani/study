package com.example.elasticSearch.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="order",type="_doc")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3028104381373449123L;

	@Id
	@Field(type=FieldType.Long)
	private Long id;
	
	@Field(type=FieldType.Date)
	private Date purchased_at;
	
	
	@Field(type=FieldType.Keyword)
	private String sales_channel;
	
	@Field(type=FieldType.Object)
	private Salesman salesman;
	
	
	@Field(type=FieldType.Keyword)
	private String status;
	
	@Field(type=FieldType.Double)
	private double total_amount;
	
	@Field(type=FieldType.Nested)
	private List<Line> lines;

	@Override
	public String toString() {
		return "Order [id=" + id + ", purchased_at=" + purchased_at + ", sales_channel=" + sales_channel + ", salesman="
				+ salesman + ", status=" + status + ", total_amount=" + total_amount + ", lines=" + lines + "]";
	}
	
	
}

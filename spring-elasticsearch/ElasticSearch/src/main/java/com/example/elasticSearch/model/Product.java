package com.example.elasticSearch.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName="product",type="default")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3028104381373449123L;

	@Id
	@Field(type=FieldType.Long)
	private Long id;
	
	@Field(type=FieldType.Date,format=DateFormat.custom,pattern="yyyy/MM/dd HH:mm:ss||yyyy/MM/dd||epoch_millis")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy/MM/dd")
	private Date created;
	
	@Field(type=FieldType.Double)
	private Double discount;
	
	@Field(type=FieldType.Long)
	private Long in_stock;
	
	@Field(type=FieldType.Boolean)
	private Boolean is_active;
	
	@Field(type=FieldType.Text)
	private String name;
	
	@Field(type=FieldType.Long)
	private Long price;
	
	@Field(type=FieldType.Long)
	private Long sold;
	
	@Field(type=FieldType.Text)
	private String[] tags;
	
	@Field(type=FieldType.Text)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getIn_stock() {
		return in_stock;
	}

	public void setIn_stock(Long in_stock) {
		this.in_stock = in_stock;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getSold() {
		return sold;
	}

	public void setSold(Long sold) {
		this.sold = sold;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", created=" + created + ", discount=" + discount + ", in_stock=" + in_stock
				+ ", is_active=" + is_active + ", name=" + name + ", price=" + price + ", sold=" + sold + ", tags="
				+ Arrays.toString(tags) + ", description=" + description + "]";
	}
	
	
}

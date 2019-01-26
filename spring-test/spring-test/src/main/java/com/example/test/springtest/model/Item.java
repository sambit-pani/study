package com.example.test.springtest.model;

public class Item {

	private int id;
	private String name;
	private float price;
	private int quantity;
	public Item(int id, String name, float price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}

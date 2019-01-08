package com.example.mongodb.model;

public class Rating {

	private int year;
	
	private int rating;

	
	public Rating(int year, int rating) {
		super();
		this.year = year;
		this.rating = rating;
	}

	public Rating() {};
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}

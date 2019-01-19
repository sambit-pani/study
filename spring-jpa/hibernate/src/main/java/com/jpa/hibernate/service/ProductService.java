package com.jpa.hibernate.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hibernate.dao.ProductDao;
import com.jpa.hibernate.model.Cart;
import com.jpa.hibernate.model.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public void saveProduct(Product product) {
		dao.saveProduct(product);
	}
	
	public void saveCart(Cart cart) {
		dao.saveCart(cart);
	}
}

package com.jpa.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.model.Cart;
import com.jpa.hibernate.model.Product;

@Repository
public class ProductDao extends BasicDao{

	@Autowired
	public ProductDao(SessionFactory sessionfactory) {
		super(sessionfactory);
	}

	public void saveProduct(Product product) {
		getHibernateTemplate().save(product);
	}
	
	public void saveCart(Cart cart) {
		getHibernateTemplate().save(cart);
	}
}

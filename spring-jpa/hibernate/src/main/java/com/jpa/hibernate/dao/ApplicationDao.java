package com.jpa.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.model.Employee;

@Repository
public class ApplicationDao extends BasicDao{

	public ApplicationDao(SessionFactory sessionfactory) {
		super(sessionfactory);
	}
	
	public void saveEmployee(Employee emp) {
		getHibernateTemplate().save(emp);
	}

}

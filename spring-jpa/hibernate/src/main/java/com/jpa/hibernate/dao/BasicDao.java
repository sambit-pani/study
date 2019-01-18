package com.jpa.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BasicDao extends HibernateDaoSupport{

	@Autowired
	public BasicDao(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}
	 protected <T> DetachedCriteria getCriteria(Class<T> clazz) {
		 return DetachedCriteria.forClass(clazz);
	 }
	 
	 protected <T> List<T> getList(DetachedCriteria criteria){
		 return (List<T>)getHibernateTemplate().findByCriteria(criteria);
	 }
}

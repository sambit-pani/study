package com.jpa.hibernate.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BasicDao extends HibernateDaoSupport{

	 protected <T> DetachedCriteria getCriteria(Class<T> clazz) {
		 return DetachedCriteria.forClass(clazz);
	 }
}

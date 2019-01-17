package com.jpa.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.model.User;

@Repository
public class UserDao extends BasicDao {

	@Autowired
	public UserDao(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	public User getUserById(int id) {
		DetachedCriteria criteria = getCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
}

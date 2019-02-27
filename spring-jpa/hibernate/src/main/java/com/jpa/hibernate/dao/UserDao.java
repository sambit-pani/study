package com.jpa.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.model.User;
import com.jpa.hibernate.model.User.SEX;

@Repository
public class UserDao extends BasicDao {

	/*@Autowired
	public UserDao(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}*/

	public UserDao(SessionFactory sessionfactory) {
		super(sessionfactory);
	}

	public User getUserById(int id) {
		DetachedCriteria criteria = getCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
	
	public List<User> getUsers(){
		DetachedCriteria criteria = getCriteria(User.class);
		criteria.addOrder(Order.asc("name"));
		return getList(criteria);
	}

	public List<User> getUserBySex(SEX sex) {
		DetachedCriteria criteria = getCriteria(User.class);
		/*
		 * criteria.add(Restrictions.eq("sex", sex));
		 * criteria.add(Restrictions.gt("salary", 20000.00));
		 */
		criteria.add(Restrictions.or(Restrictions.eq("sex", sex),
				Restrictions.and(Restrictions.le("salary", 20000.00),
						Restrictions.gt("salary", 10000.00))));
		return getList(criteria);
	}
	
	@Transactional
	public void testHibernate() {
		Session session = getSessionFactory().getCurrentSession();
		User user = session.load(User.class, 1);
		System.out.println("Get User from DB");
		System.out.println(user);
		user = session.load(User.class, 1);
		System.out.println("Get User from DB");
		System.out.println(user);
		
	}
	
	
}

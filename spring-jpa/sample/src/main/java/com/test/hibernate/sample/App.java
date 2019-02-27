package com.test.hibernate.sample;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.model.User;
import com.test.hibernate.model.User.SEX;

import net.sf.ehcache.CacheManager;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			user = session.load(User.class, 1);
			System.out.println("Got User ");
			System.out.println(user);
			User newUser = getUser();user.setActive(true);
			session.save(user);
			int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
					  .getCache("com.test.hibernate.model.User").getSize();
			System.out.println("2nd level cache size : "+size);
			System.out.println("user got saved");
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		Transaction tx1 = null;
		User user1 = null;
		Session session1 = sf.openSession();
		try {
			
			tx1 = session1.beginTransaction();
			user1 = session1.load(User.class, 1);
			System.out.println("Got User ");
			System.out.println(user1);
			int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
					  .getCache("com.test.hibernate.model.User").getSize();
			System.out.println("2nd level cache size : "+size);
			tx1.commit();
		} catch (Exception e) {
			if (tx1 != null)
				tx1.rollback();
			e.printStackTrace();
		} finally {
			session1.close();
		}
		
	}
	
	public static User getUser() {
		return new User("tomy", new Date(), false, 12010, SEX.MALE, new Date(), new Date(), new Date(), new Date());
	}
}

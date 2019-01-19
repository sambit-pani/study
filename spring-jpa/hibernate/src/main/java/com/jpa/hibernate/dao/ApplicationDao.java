package com.jpa.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jpa.hibernate.model.Department;
import com.jpa.hibernate.model.Employee;
import com.jpa.hibernate.model.Location;
import com.jpa.hibernate.model.Project;

@Repository
public class ApplicationDao extends BasicDao{

	private static final String ID = "id";
	
	
	public ApplicationDao(SessionFactory sessionfactory) {
		super(sessionfactory);
	}
	
	public void saveEmployee(Employee emp) {
		getHibernateTemplate().saveOrUpdate(emp);
	}

	public void saveDepartment(Department dept) {
		getHibernateTemplate().saveOrUpdate(dept);
		
	}
	public void saveProject(Project proj) {
		getHibernateTemplate().saveOrUpdate(proj);
	}
	public void saveLocation(Location loc) {
		getHibernateTemplate().saveOrUpdate(loc);
	}
	
	public Employee getEmployeeById(int id) {
		DetachedCriteria criteria = getCriteria(Employee.class);
		criteria.add(Restrictions.eq(ID, id));
		return (Employee) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
	
	public Department getDepartment(int id) {
		DetachedCriteria criteria = getCriteria(Department.class);
		criteria.add(Restrictions.eq(ID, id));
		return (Department) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
	
	public Project getProjectById(int id) {
		DetachedCriteria criteria = getCriteria(Project.class);
		criteria.add(Restrictions.eq(ID, id));
		return (Project) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
	
	public Location getLocationById(int id) {
		DetachedCriteria criteria = getCriteria(Location.class);
		criteria.add(Restrictions.eq(ID, id));
		return (Location) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
}

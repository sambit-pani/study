package com.jpa.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

	public static enum SEX {
		MALE, FEMALE
	}

	public User(String name, Date dob, boolean isActive, double salary, SEX sex, Date date1, Date date2, Date created,
			Date modified) {
		super();
		this.name = name;
		this.dob = dob;
		this.isActive = isActive;
		this.salary = salary;
		this.sex = sex;
		this.date1 = date1;
		this.date2 = date2;
		this.created = created;
		this.modified = modified;
	}

	public User() {
	}

	@Id
	private int id;

	private String name;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dob;

	private boolean isActive;

	private double salary;

	private SEX sex;

	@Column
	@Temporal(TemporalType.TIME)
	private Date date1;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date2;

	private Date created;

	private Date modified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public SEX getSex() {
		return sex;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

}

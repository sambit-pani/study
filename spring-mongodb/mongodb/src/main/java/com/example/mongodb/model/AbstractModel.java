package com.example.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;


public abstract class AbstractModel {

	@Id
	private Long id;
	
	private Date created;
	
	private Date modified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

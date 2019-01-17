package com.jpa.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Religion {

	private String religion;
	
	private String subReligion;
	
	
	public Religion(String religion, String subReligion) {
		super();
		this.religion = religion;
		this.subReligion = subReligion;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSubReligion() {
		return subReligion;
	}

	public void setSubReligion(String subReligion) {
		this.subReligion = subReligion;
	}
	
	
}

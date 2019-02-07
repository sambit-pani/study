package com.example.elasticSearch.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "user", type = "default", createIndex=false)
public class User {

		@Id
	    @Field(type = FieldType.Long)
	    private Long id;

	    @Field(type = FieldType.Text)
	    private String firstName;

	    @Field(type = FieldType.Text)
	    private String lastName;

	    @Field(type = FieldType.Text)
	    private String middleName;
	    
	    @Field(type=FieldType.Keyword)
	    private String email; 
	    
	    @Field(type=FieldType.Text)
	    private String country;
	    
	    @Field(type=FieldType.Text)
	    private String postalCode;
	    
	    @Field(type=FieldType.Date,format=DateFormat.basic_date)
	    private Date createDate;
	    
	    @Field(type=FieldType.Date,format=DateFormat.basic_date)
	    private Date updateDate;
	    
	    @Field(type=FieldType.Boolean)
	    private Boolean isActive;

	    @Field(type=FieldType.Keyword)
	    private Status status;
	    
	    @Field(type=FieldType.Text)
	    private String[] relatives;
	    
	    
	    
	    public User() {}
		public User(Long id, String firstName, String lastName, String middleName, String email, String country,
				String postalCode, Date createDate, Date updateDate, Boolean isActive, Status status,
				String[] relatives) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.middleName = middleName;
			this.email = email;
			this.country = country;
			this.postalCode = postalCode;
			this.createDate = createDate;
			this.updateDate = updateDate;
			this.isActive = isActive;
			this.status = status;
			this.relatives = relatives;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public String[] getRelatives() {
			return relatives;
		}

		public void setRelatives(String[] relatives) {
			this.relatives = relatives;
		}
	    
	    
	    
}

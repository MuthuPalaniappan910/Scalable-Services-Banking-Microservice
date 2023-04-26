package com.scalableservices.customer.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "CustomerId")
	  private Long customerId;
	  
	  @Column(name = "CustomerName")
	  private String customerName;
	  
	  @Column(name = "Age")
	  private Long age;
	 
	  @Column(name = "City")
	  private String city;
	  
	  @Column(name="ProfileCreatedOn")
	  private LocalDateTime profileCreatedOn;
	  
	  @Column(name="Deleted")
	  private Boolean deleted;
	  
	  @Column(name="ModifiedTime")
	  private LocalDateTime modifiedTime;

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDateTime getProfileCreatedOn() {
		return profileCreatedOn;
	}

	public void setProfileCreatedOn(LocalDateTime profileCreatedOn) {
		this.profileCreatedOn = profileCreatedOn;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}

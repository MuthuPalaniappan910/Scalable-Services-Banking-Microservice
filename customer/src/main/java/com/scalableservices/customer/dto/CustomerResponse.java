package com.scalableservices.customer.dto;

import java.time.LocalDateTime;

public class CustomerResponse {
	
	private Long customerId;
	private Long age;
	private String city;
	private LocalDateTime profileCreatedOn;
	private Boolean deleted;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

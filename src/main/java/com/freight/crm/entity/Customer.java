package com.freight.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_ID")
        private int customerID;  
	@Column(name="name")
        private String title;
	@Column(name="mc_number")	
		private Long mcNumber;
	@Column(name="dot_number")	
		private Long dotNumber;
	@Column(name="city")	
		private String city;
	@Column(name="state")	
		private String state;
	@Column(name="address")	
		private String address;
	@Column(name="phone_number")	
		private String phoneNumber;
	@Column(name="email")	
		private String email;
	@Column(name="fax")	
		private String fax;
	@Column(name="description")	
		private String description;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getMcNumber() {
		return mcNumber;
	}
	public void setMcNumber(Long mcNumber) {
		this.mcNumber = mcNumber;
	}
	public Long getDotNumber() {
		return dotNumber;
	}
	public void setDotNumber(Long dotNumber) {
		this.dotNumber = dotNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

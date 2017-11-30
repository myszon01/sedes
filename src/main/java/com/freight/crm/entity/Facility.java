package com.freight.crm.entity;




import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Facilities")
public class Facility {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="facility_ID")
        private int facilityID;  
	@Column(name="name")
        private String name;
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
	@Column(name="description")	
		private String description;
	@OneToMany(mappedBy="Facilities")
    	private Set<PickDrop> picksDrops ;
	
	
	public int getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<PickDrop> getPicksDrops() {
		return picksDrops;
	}
	public void setPicksDrops(Set<PickDrop> picksDrops) {
		this.picksDrops = picksDrops;
	}

	
	
	
}

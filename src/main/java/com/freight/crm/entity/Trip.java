package com.freight.crm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Trips")
public class Trip implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trip_ID")
        private int tripID; 
	@ManyToOne
	   private Trailer Trailer;
	
	@ManyToOne
	   private Driver driver;
	
	@ManyToOne
	   private Truck truck;

	public int getTripID() {
		return tripID;
	}

	public void setTripID(int tripID) {
		this.tripID = tripID;
	}

	

	public Trailer getTrailer() {
		return Trailer;
	}

	public void setTrailer(Trailer trailer) {
		Trailer = trailer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	
}

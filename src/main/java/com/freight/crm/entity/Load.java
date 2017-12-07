package com.freight.crm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Loads")
public class Load{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="load_ID")
        private int loadID;  
	@Column(name="customer_ID")
        private String title;
	@Column(name="rate")	
		private Long rate;
	@Column(name="extra_cost")	
		private Long extraCost;
	@Column(name="instruction")	
		private String instruction;
	
	@ManyToOne
	   private Customer customer;
	
	@OneToMany(mappedBy="load")
		private Set<PickDrop> picksDrops ;
	
	@OneToMany(mappedBy="LoadsLoad")
		private Set<TrailerHaveLoad> trailerHasLoad ;



	public int getLoadID() {
		return loadID;
	}

	public void setLoadID(int loadID) {
		this.loadID = loadID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public Long getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(Long extraCost) {
		this.extraCost = extraCost;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<PickDrop> getPicksDrops() {
		return picksDrops;
	}

	public void setPicksDrops(Set<PickDrop> picksDrops) {
		this.picksDrops = picksDrops;
	}

	public Set<TrailerHaveLoad> getTrailerHasLoad() {
		return trailerHasLoad;
	}

	public void setTrailerHasLoad(Set<TrailerHaveLoad> trailerHasLoad) {
		this.trailerHasLoad = trailerHasLoad;
	}
	
	
	
	
	
	
	
	
}

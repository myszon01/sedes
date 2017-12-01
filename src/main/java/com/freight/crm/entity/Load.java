package com.freight.crm.entity;

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
public class Load {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="loadID")
        private int articleId;  
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
	
	@OneToMany(mappedBy="Loads")
		private Set<PickDrop> picksDrops ;
	
	@OneToMany(mappedBy="Loads")
		private Set<TrailerHasLoad> trailerHasLoad ;
	
	
	
	
	
	
	
	
}

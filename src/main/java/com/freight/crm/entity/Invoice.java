package com.freight.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoice_ID")
        private int invoiceID;  
	@OneToOne
        private Load LoadID;
	@Column(name="rate")	
		private Long rate;
	@Column(name="extra_cost")	
		private Long extraCost;
	@Column(name="instruction")	
		private String instruction;
	@ManyToOne
	   private Customer customer;

}

package com.freight.crm.entity;

import java.io.Serializable;

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
public class Invoice implements Serializable{
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
	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public Load getLoadID() {
		return LoadID;
	}
	public void setLoadID(Load loadID) {
		LoadID = loadID;
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
	
}

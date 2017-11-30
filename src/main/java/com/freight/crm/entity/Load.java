package com.freight.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	   private Customers customer;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
	
}

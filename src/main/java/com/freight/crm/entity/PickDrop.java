package com.freight.crm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="picks_drops")
public class PickDrop implements Serializable{

	@ManyToOne
    @JoinColumn(name="facility_ID", nullable=false)
    private Facility facility;
	
	@ManyToOne
    @JoinColumn(name="load_ID", nullable=false)
    private Load load;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="picks_drops_ID")
        private int pickDropID;  
	@Column(name="work_type")
    	private String workType;
	@Column(name="time")
		private LocalTime time;
	@Column(name="date")
		private LocalDate date;
	@Column(name="instruction")
		private String instruction;
	
	
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public Load getLoad() {
		return load;
	}
	public void setLoad(Load load) {
		this.load = load;
	}
	public int getPickDropID() {
		return pickDropID;
	}
	public void setPickDropID(int pickDropID) {
		this.pickDropID = pickDropID;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	
}

package com.freight.crm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Trailers_have_Loads")
public class TrailerHaveLoad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Trailers_has_Loadscol")
        private int TrailersHasLoadsID;
	
	@ManyToOne
    @JoinColumn(name="Loads_load_ID", nullable=false)
    	private Load LoadsLoad;
	
			
	@ManyToOne
    @JoinColumn(name="Trailers_trailer_ID", nullable=false)
	  	private Trailer TrailersTrailer;

	
	
	public int getTrailersHasLoadsID() {
		return TrailersHasLoadsID;
	}


	public void setTrailersHasLoadsID(int trailersHasLoadsID) {
		TrailersHasLoadsID = trailersHasLoadsID;
	}


	
	
}

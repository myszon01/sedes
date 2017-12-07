package com.freight.crm.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Trailers")
public class Trailer{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trailer_ID")
        private int trailerID;
	
	@OneToMany(mappedBy="TrailersTrailer")
		private Set<TrailerHaveLoad> trailerHaveLoad ;

	public int getTrailerID() {
		return trailerID;
	}

	public void setTrailerID(int trailerID) {
		this.trailerID = trailerID;
	}

	public Set<TrailerHaveLoad> getTrailerHaveLoad() {
		return trailerHaveLoad;
	}

	public void setTrailerHaveLoad(Set<TrailerHaveLoad> trailerHaveLoad) {
		this.trailerHaveLoad = trailerHaveLoad;
	}

	
	
	
}

package com.freight.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Trailer_has_Loads")
public class TrailerHasLoad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Trailers_has_Loadscol")
        private int TrailersHasLoadsID;
	
	@ManyToOne
    @JoinColumn(name="Loads_load_ID", nullable=false)
    	private Load LoadsLoadID;
	
			
	@ManyToOne
    @JoinColumn(name="Trailers_trailer_ID", nullable=false)
    	private Trailer TrailersTrailerID;
	
	
}

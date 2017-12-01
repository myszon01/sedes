package com.freight.crm.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Trailers")
public class Trailer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trailer_ID")
        private int trailerID;
	
	@OneToMany(mappedBy="Trailers")
		private Set<TrailerHasLoad> trailerHasLoad ;
}

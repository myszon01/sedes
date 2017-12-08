package com.freight.crm.dao;

import java.util.List;

import com.freight.crm.entity.Facility;

public interface IFacilityDAO {
	
	List<Facility> getAllFacilitys();
	Facility getFacilityById(int facilityId);
    void addFacility(Facility facility);
    void updateFacility(Facility facility);
    void deleteFacility(int facilityId);
    boolean facilityExists(int facilityId);
    
}

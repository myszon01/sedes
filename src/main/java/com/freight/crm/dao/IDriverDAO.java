package com.freight.crm.dao;

import java.util.List;

import com.freight.crm.entity.Driver;

public interface IDriverDAO {
	
	List<Driver> getAllDrivers();
	Driver getDriverById(Driver driver);
    void addDriver(Driver driver);
    void updateDriver(Driver driver);
    void deleteDriver(int driverID);
    boolean adriverExists(Driver driver);

}

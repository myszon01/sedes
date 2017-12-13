package com.freight.crm.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.freight.crm.entity.Customer;



public interface ICustomerService extends PagingAndSortingRepository<Customer, Long> {
	/*
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
    boolean addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);*/
	
	
}

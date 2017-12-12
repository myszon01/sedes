package com.freight.crm.service;

import java.util.List;

import com.freight.crm.entity.Customer;

public interface CustomerJpaRepositoryCustom {
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
    boolean addCustomer(Customer customer);
    void updateCustomer(Customer customer);
}

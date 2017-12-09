package com.freight.crm.dao;

import java.util.List;

import com.freight.crm.entity.Customer;

public interface ICustomerDAO {
	List<Customer> getAllCustomers();
	Customer getCustomerById(int articleId);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    boolean customerExists(String customerMC);

}

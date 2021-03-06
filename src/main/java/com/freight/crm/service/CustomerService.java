package com.freight.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freight.crm.dao.ICustomerDAO;
import com.freight.crm.entity.Customer;
@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}

	@Override
	public synchronized boolean addCustomer(Customer customer) {
		 if (customerDAO.customerExists(customer.getCity())) {
	    	   return false;
	       } else {
	    	   customerDAO.addCustomer(customer);
	    	   return true;
	       }
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}

}

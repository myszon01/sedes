package com.freight.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.freight.crm.dao.ICustomerDAO;
import com.freight.crm.entity.Customer;
@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	public Iterable<Customer> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Customer> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> findAll() {
		return customerDAO.getAllCustomers();
		
	}

	@Override
	public Iterable<Customer> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(Long arg0) {
		
		Customer obj = customerDAO.getCustomerById(3);
		return obj;
	}

	@Override
	public <S extends Customer> S save(S arg0) {
		customerDAO.updateCustomer(arg0);
		return null;
	}

	@Override
	public <S extends Customer> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/*@Override
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
		
	}*/

}

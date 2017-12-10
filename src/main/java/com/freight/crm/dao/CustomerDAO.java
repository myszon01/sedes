package com.freight.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freight.crm.entity.Customer;
@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO{
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String sql = "FROM Customer as cust ORDER BY cust.customerID";
		return (List<Customer>) entityManager.createQuery(sql).getResultList();
	
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer cust = getCustomerById(customer.getCustomerID());
		cust.setName(customer.getName());
		cust.setAddress(customer.getAddress());
		entityManager.flush();
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
		
	}

	@Override
	public boolean customerExists(String customerMC) {
		String sql = "FROM Customer as cust WHERE cust.customer_ID = ? ;";
		int count = entityManager.createQuery(sql).setParameter(1, customerMC)
				.getResultList().size();
		return count > 0 ? true : false;
	}

}

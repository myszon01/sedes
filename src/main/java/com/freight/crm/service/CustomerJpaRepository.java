package com.freight.crm.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.freight.crm.entity.Customer;

public interface CustomerJpaRepository extends PagingAndSortingRepository<Customer, Long >, CustomerJpaRepositoryCustom {
	
	
}

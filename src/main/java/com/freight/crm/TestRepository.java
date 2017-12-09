package com.freight.crm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freight.crm.entity.Customer;
import com.freight.crm.entity.Load;

public interface TestRepository extends JpaRepository<Customer,Integer> {}

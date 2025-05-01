package com.infytel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infytel.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{ 
	
	@Query("select cus from Customer cus where cus.address = ?1")
	Customer findByAddressUsingQueryApproach (String address);

	
} 

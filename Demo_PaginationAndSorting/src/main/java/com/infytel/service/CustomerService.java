package com.infytel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO; 



public interface CustomerService { 

	public void insertCustomer(CustomerDTO customer) ; 

		Page<Customer> findAll(Pageable page); 
	
}
package com.infytel.service;

import com.infytel.dto.CustomerDTO; 
public interface CustomerService { 
CustomerDTO findbyName(String name);
public void insertCustomer(CustomerDTO customer) ; 
	public CustomerDTO getCustomer(Long phoneno);
} 

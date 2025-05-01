package com.infytel.service;

import java.util.List;

import com.infytel.dto.CustomerClassPRojection;
import com.infytel.dto.CustomerDTO;






public interface CustomerService { 

	public List<CustomerClassPRojection>findbyName(String name);

	public void insertCustomer(CustomerDTO customer) ; 
	
	public CustomerDTO getCustomer(Long phoneno);

} 
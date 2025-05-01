package com.infytel.service;

import java.util.List;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerInterfaceProjection;





public interface CustomerService { 

	List<CustomerInterfaceProjection> findAllCustomer();

	public void insertCustomer(CustomerDTO customer) ; 
	
	public CustomerDTO getCustomer(Long phoneno);

} 
package com.infytel.service;

import com.infytel.dto.CustomerDTO; 



public interface CustomerService { 

 

	public void insertCustomer(CustomerDTO customer) ; 
	
	public CustomerDTO getCustomer(Long phoneno);
	
	public String updateCustomer(Long phoneNo,Integer newPlanId); 

} 
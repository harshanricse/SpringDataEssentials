package com.infytel.service;

import java.util.List;

import com.infytel.dto.CustomerDTO;
import com.infytel.exception.InfyTelException;

public interface CustomerService {

	// Here, getCustomer method will access the repository layer method to get Customer record
		public CustomerDTO getCustomer(Long phoneNumber) throws InfyTelException;
			

	    // and getAll  method will get all the Customer record from the db
	    public List<CustomerDTO> getAll() throws InfyTelException ;
	
}

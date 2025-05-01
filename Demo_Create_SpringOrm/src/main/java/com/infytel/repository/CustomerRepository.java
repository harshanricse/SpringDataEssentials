package com.infytel.repository;
import java.util.List;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

public interface CustomerRepository {

	//This  method is used to get all the Customer record from the db
	public List<Customer> getAll();
	
    //The getCustomer method will get us the Customer details for a given phone number
	public CustomerDTO getCustomer(Long phoneNumber);
	
	// This method will insert a Customer record into the db
    public void insert(CustomerDTO customerDTO);

}

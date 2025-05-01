package com.infytel.service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

public interface CustomerService { 

	void insertCustomer(CustomerDTO customer) ; 

	Customer getCustomer(String address);
}
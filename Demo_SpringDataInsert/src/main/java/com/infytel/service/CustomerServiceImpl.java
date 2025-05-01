package com.infytel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;

@Service("customerService") 

public class CustomerServiceImpl implements CustomerService{ 

  @Autowired 

  private CustomerRepository  repository;

  @Override
  public void insertCustomer(CustomerDTO customerDTO) {
	  repository.save(CustomerDTO.prepareCustomerEntity(customerDTO)); 
  }  

} 

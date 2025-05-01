package com.infytel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.DemoSpringBootApplication;
import com.infytel.domain.Customer;
import com.infytel.dto.CustomerClassPRojection;
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

  @Override
  public CustomerDTO getCustomer(Long phoneno) {

	  Optional<Customer> optionalCustomer = repository.findById(phoneno);
	  Customer customerEntity = new Customer();
	  if(optionalCustomer.isPresent())
		  customerEntity = optionalCustomer.get(); 

	  return Customer.prepareCustomerDTO(customerEntity); 

	  }	
  
  public List<CustomerClassPRojection>findbyName(String name)
  {
  	List<CustomerClassPRojection>customer=repository.findByName(name);
  
  	return customer;
  }


} 

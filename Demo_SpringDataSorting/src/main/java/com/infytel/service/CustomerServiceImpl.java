package com.infytel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;

//All required imports 

import org.springframework.data.domain.*; 



@Service("customerService") 
public class CustomerServiceImpl implements CustomerService{ 

	@Autowired 
	
	private CustomerRepository  repository;  
	
	 

             @Override 

			public void insertCustomer(CustomerDTO customer) { 
			
            	 repository.save(CustomerDTO.prepareCustomerEntity(customer)); 
             } 

				@Override 
				
				public Page<Customer> findAll(Pageable page) { 
				
				return repository.findAll(page); 
				
				
				
				}

				@Override 

				public List<Customer> findAll(Sort sort) { 

				List<Customer> sortedCustomers=new ArrayList<>();  

				for(Customer c:repository.findAll(sort)) 

				   	       sortedCustomers.add(c); 

				              return sortedCustomers; 

				} 

} 
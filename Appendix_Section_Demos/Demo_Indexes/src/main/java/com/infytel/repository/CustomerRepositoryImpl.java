package com.infytel.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

	@PersistenceContext
	private EntityManager entityManager;	
	
    


    
    @Override
    public CustomerDTO getCustomer(Long phoneNumber) {
  		CustomerDTO customerDTO=null;
//The find method of entity manage interface is used to find Customer based on	phoneNumber
  		Customer customer = entityManager.find(Customer.class, phoneNumber);
  		if(customer!=null){
  			customerDTO=new CustomerDTO();
  			customerDTO.setPhoneNumber(customer.getPhoneNumber());
  			customerDTO.setAge(customer.getAge());
  			customerDTO.setAddress(customer.getAddress());
  			customerDTO.setGender(customer.getGender());
  			customerDTO.setName(customer.getName());
  			customerDTO.setPlanId(customer.getPlanId());
  		}

//If there exists no customer with the same phone number, then customerDTO object is created and values are set and returned.
  		return customerDTO;
    
  	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    





	@Override
	public void deleteCustomer(Long phoneNo1) {
		// TODO Auto-generated method stub
		System.out.println("Step2");
		Customer cus=entityManager.find(Customer.class, phoneNo1);
		if(cus!=null)
		{
		entityManager.remove(cus); 
		}
		
		
	}


	
}

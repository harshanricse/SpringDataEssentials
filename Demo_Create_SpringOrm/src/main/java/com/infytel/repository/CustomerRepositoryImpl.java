package com.infytel.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

	@PersistenceContext
	private EntityManager entityManager;	
	
    @Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {

//Here we have used the createQuery method to generate the query and getResultList method get the customerList
		Query query = entityManager.createQuery("Select c from Customer c");
		return query.getResultList();
    
	}
    
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
	public void insert(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setAge(customerDTO.getAge());
		customer.setAddress(customerDTO.getAddress());
		customer.setName(customerDTO.getName());
		customer.setGender(customerDTO.getGender());
		customer.setPlanId(customerDTO.getPlanId());
		entityManager.persist(customer);
	
	}


	
}

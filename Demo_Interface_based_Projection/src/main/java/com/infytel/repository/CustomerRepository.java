package com.infytel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infytel.domain.Customer;

import com.infytel.dto.CustomerInterfaceProjection;



public interface CustomerRepository extends CrudRepository<Customer, Long>{ 

	@Query(value="select name,address from Customer",nativeQuery = true)
	List<CustomerInterfaceProjection> findAllCustomer();
} 

package com.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.infytel.domain.Customer;

//From Spring Boot 3, paging and sorting repository will not extend the CRUD repository 
//rather  they extend the repository interface 

public interface CustomerRepository extends JpaRepository<Customer, Long>{ 

} 

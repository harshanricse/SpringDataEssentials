package com.infytel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerClassPRojection;




public interface CustomerRepository extends CrudRepository<Customer, Long>{ 

	List<CustomerClassPRojection> findByName(String name);//(using Methods)
    //         Or
//             @Query("select new //com.infytel.dto.CustomerClassPRojection(c.name,c.address) from Customer c //where c.name=?1")                              (using @Query Annotation)
//List<CustomerClassPRojection> findByName(String name);  

} 

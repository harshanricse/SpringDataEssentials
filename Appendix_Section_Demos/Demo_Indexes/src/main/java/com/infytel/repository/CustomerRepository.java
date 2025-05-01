package com.infytel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

public interface CustomerRepository{

	void deleteCustomer(Long phoneNo1);

	CustomerDTO getCustomer(Long phoneNumber);


	
	
}

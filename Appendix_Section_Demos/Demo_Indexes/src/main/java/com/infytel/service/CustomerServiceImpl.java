package com.infytel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.exception.InfyTelException;
import com.infytel.repository.CustomerRepository;

//We will annotate this class with @Service and @Transaction, to make all the public methods transactional
@Service(value="customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
		@Override
		public CustomerDTO getCustomer(Long phoneNumber) throws InfyTelException {
			CustomerDTO customerDTO = customerRepository.getCustomer(phoneNumber);
			if (customerDTO == null) {
				throw new InfyTelException("Service.CUSTOMER_NOT_FOUND");
			}
			return customerDTO;
		}

		@Override
		public void deleteCustomer(Long phoneNo1) {
			// TODO Auto-generated method stub
			System.out.println("Step1");
			customerRepository.deleteCustomer(phoneNo1);
			
			
			
		}


}

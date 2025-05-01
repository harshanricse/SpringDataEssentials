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

@Service("customerService")
@Transactional
// We will annotate this class with @Service and @Transaction, to make all the public methods transactional
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

//With getCustomer method, we will check if there is a customer by calling the getCustomer method of customer repository. If no customer is found, the Customer not found exception will be thrown and if the customer is found, it’s details will be returned.

	//Next let us create getAll() method, which will call the getAll method of customerRepository which returns a list of customers. Let us store this list in custEntityList. Next using for loop let us iterate through each customer of the list.
		@Override
		public List<CustomerDTO> getAll() throws InfyTelException {
			List<CustomerDTO> custList = new ArrayList<>();
			List <Customer> custEntityList = customerRepository.getAll();
			for (Customer customerEntity : custEntityList) {
				CustomerDTO custDTO = Customer.prepareCustomerDTO(customerEntity);
				custList.add(custDTO);
			}
			
			return custList;
		}
		
		@Override
		public void addCustomer(CustomerDTO customerDTO) throws InfyTelException {
				if (customerRepository.getCustomer(customerDTO.getPhoneNumber()) != null) {
					throw new InfyTelException("Service.CUSTOMER_ALREADY_EXISTS");
					}
					customerRepository.insert(customerDTO);
				}

		
}

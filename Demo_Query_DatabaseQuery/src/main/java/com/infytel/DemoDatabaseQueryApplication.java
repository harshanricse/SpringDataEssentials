package com.infytel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class DemoDatabaseQueryApplication implements CommandLineRunner{

	@Autowired
	ApplicationContext context;
	
	@Autowired
	CustomerService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDatabaseQueryApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Log LOGGER = LogFactory.getLog(DemoDatabaseQueryApplication.class);

		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1); 

		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2); 

		CustomerDTO customer3= new CustomerDTO(7022713745L, "Andrew", 27, 'M', "New York", 2); 

		service.insertCustomer(customer1); 

		service.insertCustomer(customer2); 

		service.insertCustomer(customer3); 
	
		Customer cus = service.getCustomer("Alberta");
	
		if(cus!=null)
			LOGGER.info("Customer found: "+cus);
		else
			LOGGER.info("Customer not found");
	
	}

}

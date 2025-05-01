package com.infytel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class DemoSpringDataInsertApplication implements CommandLineRunner{

	@Autowired
	ApplicationContext context;
	
	@Autowired
	CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataInsertApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1); 

		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2); 

		CustomerDTO customer3= new CustomerDTO(7022713722L, "Lucy", 27, 'F', "MUMBAI", 3); 

		//Now let us invoke service layer method to insert Customer 

		customerService.insertCustomer(customer1); 

		customerService.insertCustomer(customer2); 

		customerService.insertCustomer(customer3); 

		System.out.println("Records added successfully."); 

		 
		
	}

}

package com.infytel;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerInterfaceProjection;


import com.infytel.service.CustomerService;

@SpringBootApplication
public class DemoSpringBootApplication implements CommandLineRunner{

	public static long time=System.currentTimeMillis();
	@Autowired
	CustomerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(time);
		Log logger = LogFactory.getLog(getClass());
		//Scanner scanner = new Scanner(System.in);
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1); 

		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2); 

		CustomerDTO customer3= new CustomerDTO(7022713722L, "Lucy", 27, 'F', "MUMBAI", 3); 

		//Now let us invoke service layer method to insert Customer 

		service.insertCustomer(customer1); 

		service.insertCustomer(customer2); 

		service.insertCustomer(customer3); 

		System.out.println("Records added successfully."); 
		
		 
         logger.info("Let's print the details of a Customer"); 


         List<CustomerInterfaceProjection> customerDTO = service.findAllCustomer();

         logger.info("Customer Details:"); 
         
         for (CustomerInterfaceProjection customerProjectionDTO : customerDTO) {
        	 
        	 System.out.print(customerProjectionDTO.getName()+" ");
        	 System.out.println(customerProjectionDTO.getAddress());
		}

		
	}

}

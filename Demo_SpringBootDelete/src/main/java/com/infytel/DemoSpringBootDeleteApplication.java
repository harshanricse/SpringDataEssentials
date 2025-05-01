package com.infytel;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class DemoSpringBootDeleteApplication implements CommandLineRunner{
	
	@Autowired
	CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootDeleteApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Log logger = LogFactory.getLog(getClass());
		Scanner scanner = new Scanner(System.in);
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1); 

		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2); 

		CustomerDTO customer3= new CustomerDTO(7022713722L, "Lucy", 27, 'F', "MUMBAI", 3); 

		//Now let us invoke service layer method to insert Customer 

		service.insertCustomer(customer1); 

		service.insertCustomer(customer2); 

		service.insertCustomer(customer3); 

		System.out.println("Records added successfully."); 
		
		//****code to execute find*****// 
		
//         logger.info("Let's print the details of a Customer"); 
//
//         System.out.println("Enter the phone Number of the Customer whose details have to be printed."); 
//
//         Long phoneNo1 = scanner.nextLong(); 
//
//         CustomerDTO customerDTO = service.getCustomer(phoneNo1); 
//
//         logger.info("Customer Details:"); 
//
//         logger.info("Phone Number : "+customerDTO.getPhoneNumber()); 
//
//         logger.info("Name         : "+customerDTO.getName()); 
//
//         logger.info("Age          : "+customerDTO.getAge()); 
//
//         logger.info("Gender       : "+customerDTO.getAge()); 
//
//         logger.info("Address      : "+customerDTO.getAddress()); 
//
//         logger.info("Plan ID      : "+customerDTO.getPlanId()); 
		
		
		//****code to execute update*****//
		
//         System.out.println("Enter the phone Number of the Customer whose current plan has to be updated."); 
//
//		Long phoneNo2 = scanner.nextLong(); 
//
//		System.out.println("Enter the new plan id for the Customer"); 
//
//		Integer newPlanId = scanner.nextInt(); 
//
//		String msg = service.updateCustomer(phoneNo2, newPlanId); 
//
//		logger.info(msg); 
		
		System.out.println("Enter the phone Number of the Customer which has to be deleted."); 

		
		Long phoneNo = scanner.nextLong(); 

		// Invoking Service layer method to remove Customer details from 

		// Customer table 

		service.removeCustomer(phoneNo); 

		logger.info("Record Deleted"); 

		 
		
		
		
	}


}

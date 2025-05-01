package com.infytel;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infytel.dto.CustomerDTO;
import com.infytel.exception.InfyTelException;
import com.infytel.service.CustomerServiceImpl;


@SpringBootApplication
public class DemoSpringOrmApplication implements CommandLineRunner{
	
	public static final Log LOGGER = LogFactory.getLog(DemoSpringOrmApplication.class);
	
	String failMessage = "Something went wrong. Please check log file for more details."; 
    
	@Autowired
	CustomerServiceImpl customerService;
	@Autowired
	Environment environment;
		
public static void main(String[] args) {
		SpringApplication.run(DemoSpringOrmApplication.class, args);
			}
			
	@Override
	public void run(String... args) throws Exception {
				
		getAllCustomer();
		getCustomer();
		addCustomer();
			}
			
	public void getCustomer() throws InfyTelException{
				
	      try {
		Long phoneNo1 =  9898765434l;
		CustomerDTO customerDTO = customerService.getCustomer(phoneNo1);
		LOGGER.info(customerDTO);		
			}
	catch (Exception e) {
		if (e.getMessage() != null)
			LOGGER.info(environment.getProperty(e.getMessage(),failMessage));
				}
			}
			
			
	public void getAllCustomer() {
		try {
		        ArrayList<CustomerDTO> cList = (ArrayList<CustomerDTO>)customerService.getAll();
		       for (CustomerDTO customer : cList) {
			LOGGER.info(customer);
				}
			}
		catch (Exception e) {
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),failMessage));
				}
			}
	
	public void addCustomer() {				
		CustomerDTO customer1= new CustomerDTO(9009009009L, "Debashis", 27, 'M', "BBSR", 1);
		CustomerDTO customer2= new CustomerDTO(9009009010L, "Robert", 27, 'M', "PUNE", 2);
		CustomerDTO customer3= new CustomerDTO(9009009011L, "Lucy", 27, 'F', "MUMBAI", 3);
			try {
				customerService.addCustomer(customer1);
				customerService.addCustomer(customer2);
				customerService.addCustomer(customer3);	
						LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
						} 
			catch (Exception e) {
							if (e.getMessage() != null)
								LOGGER.info(environment.getProperty(e.getMessage(),failMessage));
						}
					}

	
}



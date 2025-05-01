package com.infytel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class DemoSpringDataSortingApplication implements CommandLineRunner{

	@Autowired 
	
	ApplicationContext context; 



	@Autowired 
	
	CustomerService service; 

	@Autowired
	CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataSortingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1); 

		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2); 

		CustomerDTO customer3= new CustomerDTO(7022713745L, "Andrew", 27, 'M', "New York", 2); 

		CustomerDTO customer4= new CustomerDTO(7022713746L, "Diana", 25, 'F', "Alberta", 1); 

		CustomerDTO customer5= new CustomerDTO(7022713747L, "Grace", 27, 'F', "Chicago", 1); 
		
		service.insertCustomer(customer1); 

		service.insertCustomer(customer2); 

		service.insertCustomer(customer3); 

		service.insertCustomer(customer4); 

		service.insertCustomer(customer5); 
		
		System.out.println("Entered successfully");
		
		int k=(int) (repository.count()); 
		
		Log logger = LogFactory.getLog(getClass());

        for(int i=0;i<=k;i++){ 

	        Pageable pageable = PageRequest.of(i,3); 
	
	         
	
	        logger.info("Records are: "); 
	
	        Iterable<Customer> customer8 = service.findAll(pageable); 
	
	         
	
	        for(Customer alist3 : customer8){ 
	
	             logger.info(alist3); 
	
	        } 		
        }
        
        System.out.println("Sorted records.."); 

        

        Iterable<Customer> customerIterable = service.findAll(Sort.by(Sort.Direction.DESC,"name")); 

          

         for(Customer customer : customerIterable){ 

              System.out.println(customer); 

         }     
	}
	
}
	
	



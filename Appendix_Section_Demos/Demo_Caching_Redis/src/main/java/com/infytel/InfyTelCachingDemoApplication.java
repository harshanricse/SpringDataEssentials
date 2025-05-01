package com.infytel;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerServiceImpl;

@SpringBootApplication
@EnableCaching
public class InfyTelCachingDemoApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = SpringApplication.run(InfyTelCachingDemoApplication.class, args);
		CustomerServiceImpl custServ = ac.getBean(CustomerServiceImpl.class);

		CustomerDTO cdto = new CustomerDTO();
		cdto.setName("Sam");
		cdto.setEmailId("sam@infy.com");
		cdto.setDateOfBirth(LocalDate.of(2003, 8, 30));

		Integer addedCust = custServ.addCustomer(cdto);
		
		System.out.println(custServ.getCustomer(2));
		System.out.println(custServ.getCustomer(2));
		System.out.println(custServ.getCustomer(2));
	}

}

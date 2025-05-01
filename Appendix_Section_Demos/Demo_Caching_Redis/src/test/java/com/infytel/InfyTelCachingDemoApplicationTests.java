//package com.infytel;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.infytel.config.TestRedisConfiguration;
//import com.infytel.dto.CustomerDTO;
//import com.infytel.entity.Customer;
//import com.infytel.exception.InfyTelException;
//import com.infytel.repository.CustomerRepository;
//import com.infytel.service.CustomerServiceImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestRedisConfiguration.class)
//class InfyTelCachingDemoApplicationTests {
//
////	@Test
////	void contextLoads() {
////	}
//	
//	@Mock
//	private CustomerRepository custRepo;
//	
//	@InjectMocks
//	private CustomerServiceImpl custServ;
//	
////	public InfyTelCachingDemoApplicationTests() {
////		MockitoAnnotations.initMocks(this);
////	}
//	@Test
//	public void testAddCustomer() throws InfyTelException {
//		//Mocking data
//		CustomerDTO cdto = new CustomerDTO();
//		cdto.setName("Sam");
//		cdto.setEmailId("sam@infy.com");
//		cdto.setDateOfBirth(LocalDate.of(2003, 8, 30));
//		
//		Customer cust = new Customer();
//		cust.setCustomerId(4);
//		cust.setName("Sam");
//		cust.setEmailId("sam@infy.com");
//		cust.setDateOfBirth(LocalDate.of(2003, 8, 30));
//		
//		//Mocking behaviour
//		when(custRepo.save(any(Customer.class))).thenReturn(cust);
//		
//		//call the service method
//		Integer addedCust = custServ.addCustomer(cdto);
//		
//		assertNotNull(addedCust);
//		assertEquals(4,addedCust);
//	}
//	
//	@Test
//	public void testGetCustomer() throws InfyTelException {
//		//Mocking data
//		Integer cid = 1;
//		
//		Customer cust = new Customer();
//		cust.setCustomerId(1);
//		cust.setName("Martin");
//		cust.setEmailId("martin@infy.com");
//		cust.setDateOfBirth(LocalDate.of(1999,7,1));
//		
//		//Mocking behaviour
//		when(custRepo.findById(cid)).thenReturn(Optional.of(cust));
//		//call the service method
//		CustomerDTO cdto=custServ.getCustomer(cid);
//		
//		assertNotNull(cdto);
//		assertEquals(cust.getCustomerId(),cdto.getCustomerId());
//		assertEquals(cust.getEmailId(), cdto.getEmailId());
//		assertEquals(cust.getName(), cdto.getName());
//		assertEquals(cust.getDateOfBirth(), cdto.getDateOfBirth());
//	}
//	
//	
//}

package com.infy.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.CardDTO;
import com.infy.dto.CustomerDTO;
import com.infy.entity.Card;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CardRepository;
import com.infy.repository.CustomerRepository;

@Service(value = "cardCustomerService")
@Transactional
public class CardCustomerServiceImpl implements CardCustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	ModelMapper mapper;

	@Autowired
	private CardRepository cardRepository;

	// Fetch customerDTO details
	/**
	 * This method calls findById method of customerRepository passing customerId
	 * received in parameter
	 * 
	 * @param Integer customerId
	 * @return CustomerDTO object returned from findById method of
	 *         customerRepository
	 * @throws Service.CUSTOMER_NOT_FOUND exception if findById method of
	 *                                    customerRepository returns null
	 */
	@Override
	public CustomerDTO getCustomerDetails(Integer customerId) throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		return mapper.map(customer, CustomerDTO.class);
	}

	/**
	 * This method calls save method of customerRepository passing Customer entity
	 * populated using customerDTO object received in parameter
	 * 
	 * @param CustomerDTO object
	 * @return Integer customerId after calling save method of customerRepository
	 */
	@Override
	public Integer addCustomer(CustomerDTO customerDTO) throws InfyBankException {
		Customer customer = new Customer();
		customerRepository.save(mapper.map(customerDTO, Customer.class));
		return customer.getCustomerId();
	}

	/**
	 * This method first calls findById method of customerRepository passing
	 * customerId received in parameter ,then sets card object received in parameter
	 * to the customer entity.
	 * 
	 * @param Integer customerId, CardDTO object
	 * @throws Service.CUSTOMER_NOT_FOUND exception if findById method of
	 *                                    customerRepository returns null
	 */
	@Override
	public void issueCardToExistingCustomer(Integer customerId, CardDTO cardDTO) throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		Card card = mapper.map(cardDTO, Card.class);
		List<Card> c = customer.getCards();
		c.add(card);
		customer.setCards(c);

	}

	/**
	 * This method first calls findById method of customerRepository passing
	 * customerId received in parameter ,then calls delete method of
	 * customerRepository passing customerId received in parameter
	 * 
	 * @param Integer customerId
	 * @throws Service.CUSTOMER_NOT_FOUND exception if findById method of
	 *                                    customerRepository returns null
	 */
	@Override
	public void deleteCustomer(Integer customerId) throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.delete(customer);
	}

	/**
	 * This method first calls findById method of customerRepository passing
	 * customerId received in parameter ,then calls findById method of
	 * cardRepository passing each cardId received in parameter
	 * 
	 * @param Integer customerId, List<Integer> cardIdsToDelete
	 * @throws Service.CUSTOMER_NOT_FOUND exception if findById method of
	 *                                    customerRepository returns null
	 */
	@Override
	public void deleteCardOfExistingCustomer(Integer customerId, List<Integer> cardIdsToDelete)
			throws InfyBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		for (Integer cardId : cardIdsToDelete) {
			Optional<Card> optionalCard = cardRepository.findById(cardId);
			if (optionalCard.isPresent()) {
				customer.getCards().remove(optionalCard.orElse(null));
				cardRepository.deleteById(cardId);
			}
		}
	}

	/**
	 * This method first invokes the findAll() method of the customerRepository 
	 * which returns Iterable<Customer>. This Iterable<Customer> is casted to List<Customer>
	 * Map the list of Customer entities to a list of CustomerDTOs using ModelMapper
	 */	
	@Override
	public List<CustomerDTO> getAllCustomers() throws InfyBankException {
		List<Customer> customer = (List<Customer>) customerRepository.findAll();
		return Arrays.asList(mapper.map(customer, CustomerDTO[].class));
	}

}

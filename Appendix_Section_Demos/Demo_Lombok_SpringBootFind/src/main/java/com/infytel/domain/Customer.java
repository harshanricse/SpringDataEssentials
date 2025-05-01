package com.infytel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.infytel.dto.CustomerDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {

	@Id
	@Column(name ="phone_no")
	 private Long phoneNumber;
	
	private String name;
	private Character gender;
	private Integer age;
	private String address;
	
	@Column(name="plan_id")
	private Integer planId;

	
	public static CustomerDTO prepareCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setAge(customer.getAge());
		customerDTO.setGender(customer.getGender());
		customerDTO.setPlanId(customer.getPlanId());
		customerDTO.setName(customer.getName());
		return customerDTO;
	}
	
	
}

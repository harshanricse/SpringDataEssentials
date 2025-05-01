package com.infytel.domain;



import com.infytel.dto.CustomerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
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

	public Customer() {}
	
	public Customer(Long phoneNumber, String name, Character gender, Integer age, String address, Integer planId) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.planId = planId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "Customer [phoneNumber=" + phoneNumber + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", planId=" + planId + "]";
	}
	
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

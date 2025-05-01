package com.infytel.dto;

import javax.persistence.Column;

import com.infytel.domain.Customer;

public class CustomerDTO {

private Long phoneNumber;
	
	private String name;
	private Character gender;
	private Integer age;
	private String address;
	
	@Column(name="plan_id")
	private Integer planId;
	
	public CustomerDTO() {}

	public CustomerDTO(Long phoneNumber, String name, Integer age, Character gender, String address, Integer planId) {
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
	
	public static Customer prepareCustomerEntity(CustomerDTO customerDTO) {
		Customer customerEntity = new Customer();
		customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
		customerEntity.setPlanId(customerDTO.getPlanId());
		customerEntity.setName(customerDTO.getName());
		customerEntity.setGender(customerDTO.getGender());
		customerEntity.setAge(customerDTO.getAge());
		customerEntity.setAddress(customerDTO.getAddress());
		return customerEntity;
	}
	
	
}

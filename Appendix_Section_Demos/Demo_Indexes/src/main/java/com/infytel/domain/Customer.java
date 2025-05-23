package com.infytel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.infytel.dto.CustomerDTO;

@Entity
//@Table
@Table(name = "customer",indexes = {
		@Index(name="index_Customer_name",columnList = "name")	
	})
public class Customer {

	@Id
	@Column(name = "phone_no")
	private Long phoneNumber;
	private String name;
	private Integer age;
	private Character gender;
	private String address;
	@Column(name = "plan_id")
	private Integer planId;
	
	public Customer() {}
	
	public Customer(Long phoneNumber, String name, Integer age, Character gender, String address, Integer planId) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
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
		return "Customer [phoneNumber=" + phoneNumber + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", planId=" + planId + "]";
	}
	public static CustomerDTO prepareCustomerDTO(Customer customer)
	{
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setName(customer.getName());
		customerDTO.setGender(customer.getGender());
		customerDTO.setAge(customer.getAge());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setPlanId(customer.getPlanId());
		return customerDTO;
		
	}

	
}

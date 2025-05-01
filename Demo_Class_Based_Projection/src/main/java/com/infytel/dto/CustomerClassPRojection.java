package com.infytel.dto;

public class CustomerClassPRojection {
	private String name;
	private String address;
	public CustomerClassPRojection(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerClassPRojection [name=" + name + ", address=" + address + "]";
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
}

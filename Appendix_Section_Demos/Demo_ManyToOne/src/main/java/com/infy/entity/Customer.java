package com.infy.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	private Integer customerId;
	@Column(name="emailid")
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
}

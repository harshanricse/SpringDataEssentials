package com.infy.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer loanId;
	private Double amount;
	private LocalDate issueDate;
	private String status;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
}

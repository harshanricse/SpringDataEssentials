package com.infy.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoanDTO {
	
	private Integer loanId;
	private Double amount;
	private LocalDate loanIssueDate;
	private CustomerDTO customer;
	private String status;
}

package com.infy.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
@Data
public class CustomerDTO {

	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	private List<CardDTO> cards;

}

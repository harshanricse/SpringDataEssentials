package com.infy.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CardDTO {

	private Integer cardId;
	private String cardNumber;
	private LocalDate expiryDate;

}

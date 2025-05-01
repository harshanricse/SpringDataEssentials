package com.infy.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Card {

	@Id
	private Integer cardId;

	private String cardNumber;

	private LocalDate expiryDate;

}

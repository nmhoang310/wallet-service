package com.tpssoft.walletservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	@Id
	private String cardId;

	@Column
	private String cardNumber;
	@Column
	private LocalDate expirationDate;
	@Column
	private String cvv;
	@Column
	private String cardType;
	@Column
	private LocalDate createdAt;
	@Column
	private String billingAddress;
	@Column
	private String cardHolder;
	@Column
	private String lastName;
	@Column
	private String firstName;
	@Column
	private String userId;
}

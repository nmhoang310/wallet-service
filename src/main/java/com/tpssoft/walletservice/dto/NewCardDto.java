package com.tpssoft.walletservice.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class NewCardDto {
	@NotEmpty(message = "Fist name is not empty")
	private String firstName;
	
	@NotEmpty(message = "Fist name is not empty")
	private String lastName;
	
	@NotEmpty(message = "Card number is not empty")
	@Length(min = 16, message = "Card number must be 16 digits")
	@Length(max = 16, message = "Card number must be 16 digits")
	@Pattern(regexp = "^-?\\d+\\.?\\d*$", message = "Card number is not valid")
	private String cardNumber;
	
	@NotEmpty(message = "Expiration date is not empty")
	private String expDate;
	
	@NotEmpty(message = "CVV is not empty")
	@Length(min = 3, message = "CVV must be 3 digits")
	@Length(max = 3, message = "CVV must be 3 digits")
	@Pattern(regexp = "^\\d+$", message = "CVV is not valid")
	private String cvv;
	
	@NotEmpty(message = "Card holder is not empty")
	private String cardHolder;
	
	@NotEmpty(message = "Billing Address is not empty")
	private String billingAddr;
	
	@NotEmpty(message = "Card type is not empty")
	private String cardType;
	
	private String userId;
}

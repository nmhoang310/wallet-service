package com.tpssoft.walletservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Wallet {
	@Id
	private String walletId;
	@Column
	private Double balance;
	@Column
	private String userId;
	@Column
	private LocalDate createdAt;
	@Column
	private LocalDateTime updatedAt;
}

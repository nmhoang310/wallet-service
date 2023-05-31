package com.tpssoft.walletservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.antlr.v4.runtime.misc.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;
import com.tpssoft.walletservice.entity.Card;
import com.tpssoft.walletservice.entity.Wallet;
import com.tpssoft.walletservice.service.ICardService;
import com.tpssoft.walletservice.service.IWalletService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v0/wallet")
@CrossOrigin(origins = "http://localhost:3000")
public class WalletController {
	@Autowired
	private ICardService cardService;
	@Autowired
	private IWalletService walletService;
	
	
	@PostMapping("/add-new-card") 
	public ResponseEntity<String> addNewCard(@RequestBody @Valid NewCardDto newCard) {
		if (cardService.addNewCard(newCard))
			return ResponseEntity.status(200).body("Add new Card successful");
		return ResponseEntity.status(501).body("Add new Card fail");
	}
	
	@PostMapping("/create-wallet/{userId}")
	public ResponseEntity<String> createWallet(@PathVariable(name = "userId") String userId) {
		if (walletService.createWallet(userId))
			return ResponseEntity.status(200).body("Create wallet successful");
		return ResponseEntity.status(501).body("Create wallet fail");
	}
	
	@GetMapping("/balance/{userId}")
	public double getBalance(@PathVariable(name = "userId") String userId) {
		double balance = walletService.getBalance(userId);
		return balance;
	}
	
	@GetMapping("/card/information/{userId}")
	public ResponseEntity<CardDto> getCardInformation(@PathVariable(name = "userId") String userId) {
		CardDto dto = cardService.getCardInformation(userId);
		return ResponseEntity.status(200).body(dto);
	}
	
	@GetMapping("/get-wallet-id/{userId}")
	public String getWalletId(@PathVariable(name = "userId") String userId) {
		String walletId = walletService.getWalletId(userId);
		return walletId;
	}
	
	@PutMapping("/balance/update")
	public ResponseEntity<String> updateBalance(@RequestParam String userId, @RequestParam double amount) {
		if (walletService.updateBalance(userId, amount))
			return ResponseEntity.status(200).body("Update balance Successful");
		return ResponseEntity.status(501).body("Update balance Fail");
	}
	
}

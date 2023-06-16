package com.tpssoft.walletservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;
import com.tpssoft.walletservice.service.ICardService;
import com.tpssoft.walletservice.service.IWalletService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v0/wallet")
@Slf4j
public class WalletController {
	@Autowired
	private ICardService cardService;
	@Autowired  
	private IWalletService walletService;
	
	
	@PostMapping("/add-new-card") 
	public ResponseEntity<String> addNewCard(@RequestBody NewCardDto newCard) {
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
		log.info("LOAD BALANCE =============");
		
		double balance = walletService.getBalance(userId);
		return balance;
	}
	
	@GetMapping("/card/information/{userId}/{cardId}")
	public ResponseEntity<CardDto> getCardInformation(@PathVariable(name = "userId") String userId, @PathVariable(name = "cardId") String cardId) {
//		System.out.println("cardInfor: " + idToken);
		CardDto dto = cardService.getCardInformation(userId, cardId);
		return ResponseEntity.status(200).body(dto);
	}
	
	@GetMapping("/card/{userId}")
	public List<CardDto> getListCards(@PathVariable(name = "userId") String userId) {
		List<CardDto> cards = cardService.getListCards(userId);
		return cards;
	}
	
	@GetMapping("/get-wallet-id/{userId}")
	public ResponseEntity<String> getWalletId(@PathVariable(name = "userId") String userId) {
		String walletId = walletService.getWalletId(userId); 	
		if (walletId != null) {
			return ResponseEntity.status(200).body(walletId);
		}
		return ResponseEntity.status(501).body(null);
		
	}
	
	@PutMapping("/balance/update")
	public ResponseEntity<String> updateBalance(@RequestParam String userId, @RequestParam double amount) {
		if (walletService.updateBalance(userId, amount))
			return ResponseEntity.status(200).body("Update balance Successful");
		return ResponseEntity.status(501).body("Update balance Fail");
	}
	
}

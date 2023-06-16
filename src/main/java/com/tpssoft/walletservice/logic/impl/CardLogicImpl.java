package com.tpssoft.walletservice.logic.impl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;
import com.tpssoft.walletservice.entity.Card;
import com.tpssoft.walletservice.logic.ICardLogic;
import com.tpssoft.walletservice.repository.CardRepository;

@Component
public class CardLogicImpl implements ICardLogic {
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public boolean addNewCard(NewCardDto newCard) {
		Card entity = new Card();
		entity.setCardId(NanoIdUtils.randomNanoId());
		entity.setCardNumber(newCard.getCardNumber());
		entity.setCardHolder(newCard.getCardHolder());
		entity.setCardType(newCard.getCardType());
		entity.setCreatedAt(LocalDate.now());
		entity.setCvv(newCard.getCvv());

		//convert from string to date
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
	            .parseCaseInsensitive()
	            .append(DateTimeFormatter.ofPattern("yyyy-MM"))
	            .toFormatter(Locale.ENGLISH);
	    LocalDate expDate = YearMonth.parse(newCard.getExpDate(), formatter).atEndOfMonth();
		
		entity.setExpirationDate(expDate);
		entity.setFirstName(newCard.getFirstName());
		entity.setLastName(newCard.getLastName());
		entity.setBillingAddress(newCard.getBillingAddr());
		entity.setUserId(newCard.getUserId());
		
		try {
			cardRepository.save(entity);
			return true;
		} catch (IllegalArgumentException |  OptimisticLockingFailureException ex) {
			System.out.println(ex);
			
		}
		return false;
	}
	
	@Override
	public CardDto getCardInformation(String userId, String cardId) {
		Card card = cardRepository.getInforCard(userId, cardId);
		CardDto dto = new CardDto();
		dto.setCardId(card.getCardId());
		dto.setCardNumber(card.getCardNumber());
		dto.setCvv(card.getCvv());
		dto.setExpDate(card.getExpirationDate());
		dto.setCardType(card.getCardType());
		dto.setBillingAddr(card.getBillingAddress());
		dto.setFirstName(card.getFirstName());
		dto.setLastName(card.getLastName());		
		return dto;
	}
	
	@Override
	public List<CardDto> getListCards(String userId) {
		List<CardDto> results = new ArrayList<>();
		for (Card card : cardRepository.getCardByUserId(userId)) {
			CardDto dto = new CardDto();
			dto.setCardId(card.getCardId());
			dto.setCardNumber(card.getCardNumber());
			dto.setCvv(card.getCvv());
			dto.setExpDate(card.getExpirationDate());
			dto.setCardType(card.getCardType());
			dto.setBillingAddr(card.getBillingAddress());
			dto.setFirstName(card.getFirstName());
			dto.setLastName(card.getLastName());
			
			results.add(dto);
		}
		
		return results;
	}
}

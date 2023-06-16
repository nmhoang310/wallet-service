package com.tpssoft.walletservice.service;

import java.util.List;

import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;

public interface ICardService {

	boolean addNewCard(NewCardDto newCard);

	List<CardDto> getListCards(String userId);
	
	CardDto getCardInformation(String userId, String cardId);

}

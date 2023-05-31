package com.tpssoft.walletservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;
import com.tpssoft.walletservice.logic.ICardLogic;
import com.tpssoft.walletservice.service.ICardService;

@Service
public class CardServiceImpl implements ICardService {
	@Autowired
	private ICardLogic cardLogic;

	@Override
	public boolean addNewCard(NewCardDto newCard) {
		return cardLogic.addNewCard(newCard);
	}

	@Override
	public CardDto getCardInformation(String userId) {
		return cardLogic.getCardInformation(userId);
	}
	
	
	
	
	
	
	
}

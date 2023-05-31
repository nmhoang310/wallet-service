package com.tpssoft.walletservice.logic;

import org.springframework.stereotype.Component;

import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;
import com.tpssoft.walletservice.entity.Card;

@Component
public interface ICardLogic {

	boolean addNewCard(NewCardDto newCard);

	CardDto getCardInformation(String userId);

}

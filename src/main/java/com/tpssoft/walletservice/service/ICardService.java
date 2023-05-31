package com.tpssoft.walletservice.service;

import com.tpssoft.walletservice.dto.CardDto;
import com.tpssoft.walletservice.dto.NewCardDto;

public interface ICardService {

	boolean addNewCard(NewCardDto newCard);

	CardDto getCardInformation(String userId);

}

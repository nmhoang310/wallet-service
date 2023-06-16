package com.tpssoft.walletservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpssoft.walletservice.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{
	@Query("SELECT c FROM Card c WHERE c.userId = ?1")
	List<Card> getCardByUserId(String userId);
	
	@Query("SELECT c FROM Card c WHERE c.userId = ?1 AND c.cardId = ?2")
	Card getInforCard(String userId, String cardId);
}

package com.tpssoft.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpssoft.walletservice.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{
	@Query("SELECT c FROM Card c WHERE c.userId = ?1")
	Card getCardByUserId(String userId);
}

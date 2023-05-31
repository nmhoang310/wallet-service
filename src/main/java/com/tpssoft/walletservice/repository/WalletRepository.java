package com.tpssoft.walletservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpssoft.walletservice.entity.Wallet;

import jakarta.transaction.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String>{
	@Query("SELECT w FROM Wallet w WHERE w.userId = ?1")
	Wallet getWalletByUserId(String userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Wallet w set w.balance = ?1 WHERE w.userId = ?2")
	int updateBalance(Double amount,  String userId);
}

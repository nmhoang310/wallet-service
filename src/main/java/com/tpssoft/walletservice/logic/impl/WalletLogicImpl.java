package com.tpssoft.walletservice.logic.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.tpssoft.walletservice.entity.Wallet;
import com.tpssoft.walletservice.logic.IWalletLogic;
import com.tpssoft.walletservice.repository.WalletRepository;

@Component
public class WalletLogicImpl implements IWalletLogic {
	@Autowired
	private WalletRepository walletRepository;
	
	@Override
	public boolean createWallet(String userId) {
		Wallet wallet = new Wallet();
		wallet.setWalletId(NanoIdUtils.randomNanoId());
		wallet.setUserId(userId);
		wallet.setBalance(0.00);
		wallet.setCreatedAt(LocalDate.now());
		wallet.setUpdatedAt(LocalDateTime.now());
		
		try {
			walletRepository.save(wallet);
			return true;
		} catch (IllegalArgumentException |  OptimisticLockingFailureException ex) {
			System.out.println(ex);
			
		}
		return false;
	}
	
	@Override
	public boolean updateBalance(String userId, double amount) {
		Wallet walletUpdate = walletRepository.getWalletByUserId(userId);
		walletUpdate.setBalance(walletUpdate.getBalance() + amount);
		walletUpdate.setUpdatedAt(LocalDateTime.now());
		
		try {
			walletRepository.saveAndFlush(walletUpdate);
			return true;
		} catch (IllegalArgumentException |  OptimisticLockingFailureException ex) {
			System.out.println(ex);
			
		}
		return false;
	}
	
	@Override
	public double getBalance(String userId) {
		Wallet wallet = walletRepository.getWalletByUserId(userId);
		double balance = wallet.getBalance();
		return balance;
	}
	
	@Override
	public String getWalletId(String userId) {
		Wallet wallet = walletRepository.getWalletByUserId(userId);
		String walletId = wallet.getWalletId();
		return walletId;
	}
	
}

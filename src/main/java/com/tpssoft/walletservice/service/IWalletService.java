package com.tpssoft.walletservice.service;

public interface  IWalletService {

	boolean createWallet(String userId);

	boolean updateBalance(String userId, double amount);

	double getBalance(String userId);

	String getWalletId(String userId);

	
}

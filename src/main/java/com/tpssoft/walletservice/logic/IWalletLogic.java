package com.tpssoft.walletservice.logic;

import org.springframework.stereotype.Component;

@Component
public interface IWalletLogic {

	String getWalletId(String userId);

	double getBalance(String userId);

	boolean updateBalance(String userId, double amount);

	boolean createWallet(String userId);

}

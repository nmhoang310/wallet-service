package com.tpssoft.walletservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpssoft.walletservice.logic.IWalletLogic;
import com.tpssoft.walletservice.service.IWalletService;

@Service
public class WalletServiceImpl implements IWalletService {
	@Autowired
	private IWalletLogic walletLogic;
	
	@Override
	public String getWalletId(String userId) {
		return walletLogic.getWalletId(userId);
	}

	@Override
	public double getBalance(String userId) {
		return walletLogic.getBalance(userId);
	}

	@Override
	public boolean updateBalance(String userId, double amount) {
		return walletLogic.updateBalance(userId, amount);
	}

	@Override
	public boolean createWallet(String userId) {
		return walletLogic.createWallet(userId);
	}
	
	
}

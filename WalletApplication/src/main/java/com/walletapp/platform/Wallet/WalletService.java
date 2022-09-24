package com.walletapp.platform.Wallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletRepository;
	
	public List<Wallet> getAll()
	{
		return walletRepository.findAll();
	}
	
	public Wallet createOrUpdate(Wallet wallet)
	{
		if(wallet.getId()==null)
		{
			walletRepository.save(wallet);
		}else
		{
			walletRepository.save(wallet);
		}
		return wallet;
	}

}

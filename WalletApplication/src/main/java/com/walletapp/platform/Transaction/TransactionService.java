package com.walletapp.platform.Transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walletapp.platform.Wallet.Wallet;
import com.walletapp.platform.Wallet.WalletRepository;


@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	WalletRepository walletRepository;
	
	public List<Transaction> getAll(Long walletId)
	{
		Optional<Wallet> wallet=walletRepository.findById(walletId);
		if(wallet.isPresent()) {
		return transactionRepository.findByWallet(wallet.get());
		}
		return null;
	}
	
	public Transaction createOrUpdate(Long walletId, Transaction transaction)
	{
		Optional<Wallet> wallet=walletRepository.findById(walletId);
		if(wallet.isPresent())
		{
			Wallet w=wallet.get();
			if(transaction.getType().equals(TransactionType.DEPOSIT)) {
				if(w.getBalance() >= 0) {
					w.setBalance(w.getBalance() + transaction.getAmount());
				}
			}
			else if(transaction.getType().equals(TransactionType.WITHDRAW))
			{
					if(transaction.getAmount() <= w.getBalance()) {
					w.setBalance(w.getBalance() - transaction.getAmount());
				}
			}
			transaction.setWallet(w);
			transactionRepository.save(transaction);
			return transaction;
		}
		return null;
	}
	

}

package com.walletapp.platform.Transaction;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walletapp.platform.Wallet.Wallet;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{

	List<Transaction> findByWallet(Wallet wallet);
	
}

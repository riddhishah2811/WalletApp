package com.walletapp.platform.Transaction;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/{wallet_id}")
	public ResponseEntity<?> getAllTransactions(@PathVariable Long wallet_id)
	{
		 return new ResponseEntity<>(transactionService.getAll(wallet_id),HttpStatus.OK);
	}
	
	@PostMapping("/{wallet_id}")
	public ResponseEntity<?> create (@PathVariable Long wallet_id,@Valid @RequestBody Transaction transaction)
	{
		Transaction transactionSaved = transactionService.createOrUpdate(wallet_id,transaction);
		return new ResponseEntity<Transaction>(transactionSaved, HttpStatus.CREATED);
	}

}

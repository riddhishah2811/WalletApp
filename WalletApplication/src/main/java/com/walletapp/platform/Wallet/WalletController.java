package com.walletapp.platform.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@GetMapping
	public ResponseEntity<?> getAllWallets()
	{
		return new ResponseEntity<>(walletService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create (@Valid @RequestBody Wallet wallet)
	{
		Wallet walletSaved = walletService.createOrUpdate(wallet);
		return new ResponseEntity<Wallet>(walletSaved, HttpStatus.CREATED);
	}
}

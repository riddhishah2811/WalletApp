package com.walletapp.platform.Wallet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.walletapp.platform.Transaction.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	private String accNumber;
	
	private Double balance;
	
	@PrePersist
	public void setBalance() {
		this.balance=new Double(0);}
	
	@OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,mappedBy = "wallet",orphanRemoval = true)
	private List<Transaction> transactions;
}

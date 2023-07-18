package com.xoriant.banking.model;


import javax.persistence.JoinColumn;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fromAccountNumber")
	private Account fromAccount;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "toAccountNumber")
	private Account toAccount;
	
	private double amount;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar dateOfTransaction;
	
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	private String description;
	
	@JsonProperty("accountNumber")
	private void unpackNested(Integer accountNumber) {
	    this.fromAccount = new Account();
	    fromAccount.setAccountNumber(accountNumber);
	    
	    this.toAccount = new Account();
	    toAccount.setAccountNumber(accountNumber);
	}
	
}

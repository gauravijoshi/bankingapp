package com.xoriant.banking.DTO;

import java.util.Calendar;
import com.xoriant.banking.model.AccountType;

public class EditAccountDTO {
	
	private long accountNumber;
	private double minimumBalance;
	private Calendar date;
	private String description;
	private AccountType accountType;
	
	public EditAccountDTO() {
		super();
	}

	public EditAccountDTO(long accountNumber, double minimumBalance, Calendar date, String description,
			AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.minimumBalance = minimumBalance;
		this.date = date;
		this.description = description;
		this.accountType = accountType;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	
}

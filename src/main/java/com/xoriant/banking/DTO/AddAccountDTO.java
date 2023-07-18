package com.xoriant.banking.DTO;

import java.util.Calendar;
import com.xoriant.banking.model.AccountType;

public class AddAccountDTO {
	
	private int userId;
	private double accountBalance;
	private double minimumBalance;
	private Calendar date;
	private String description;
	private AccountType accountType;
	
	public AddAccountDTO() {
		super();
	}

	public AddAccountDTO(int userId, double accountBalance, double minimumBalance, Calendar date, String description, AccountType accountType) {
		super();
		this.userId = userId;
		this.accountBalance = accountBalance;
		this.minimumBalance = minimumBalance;
		this.date = date;
		this.description = description;
		this.accountType = accountType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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

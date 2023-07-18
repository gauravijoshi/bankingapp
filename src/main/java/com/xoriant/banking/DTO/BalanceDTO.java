package com.xoriant.banking.DTO;

public class BalanceDTO {

	private long accountNumber;
	private double accountBalance;
	public BalanceDTO() {
		super();
	}
	public BalanceDTO(long accountNumber, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}

package com.xoriant.banking.DTO;

public class AccountDTO {

	private double accountBalance;
	
	public AccountDTO() {
		super();
	}
	public AccountDTO(double accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "AccountDTO [accountBalance=" + accountBalance + "]";
	}
	
	
}


	
	
	




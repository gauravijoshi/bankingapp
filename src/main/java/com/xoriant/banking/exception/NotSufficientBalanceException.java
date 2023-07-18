package com.xoriant.banking.exception;

public class NotSufficientBalanceException extends Exception{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Your Balance is not sufficient. ";
		
	}
}

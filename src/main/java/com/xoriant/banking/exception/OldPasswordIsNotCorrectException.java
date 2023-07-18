package com.xoriant.banking.exception;

public class OldPasswordIsNotCorrectException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		
		return "Old Password is not correct";
	}
}

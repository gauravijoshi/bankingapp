package com.xoriant.banking.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		
		return  " not Found";
	}
}

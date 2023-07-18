package com.xoriant.banking.service;

import java.util.List;

import com.xoriant.banking.DTO.TransactionsDTO;
import com.xoriant.banking.model.Transactions;

public interface TransactionService {


	Transactions fundTransfer(TransactionsDTO transactionsDto);
	List<Transactions> getAllTransactionsByAccountNumber(long accountNumber);
	public Transactions fundTransferCustomer(TransactionsDTO transactionsDto);
}

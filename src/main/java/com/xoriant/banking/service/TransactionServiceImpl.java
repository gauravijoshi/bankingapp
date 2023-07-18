package com.xoriant.banking.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.DTO.TransactionsDTO;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.TransactionStatus;
import com.xoriant.banking.model.Transactions;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.repository.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	TransactionDao transactionDao;
	
	
	@Override
	public Transactions fundTransfer(TransactionsDTO transactionsDto) {
		Transactions transactions = new Transactions();
		Account account1 = new Account();
		Account account2 = new Account();
		transactions.setAmount(transactionsDto.getAmount());
		long fromAccNo = transactionsDto.getFromAccount();
		account1.setAccountNumber(fromAccNo);
		transactions.setFromAccount(account1);
		long toAccNo = transactionsDto.getToAccount();
		account2.setAccountNumber(toAccNo);
		transactions.setToAccount(account2);
		boolean flag1 = accountDao.existsById(fromAccNo);
		boolean flag2 = accountDao.existsById(toAccNo);
		if(flag1==true && flag2==true) {
			AccountDTO accountDto = accountDao.getAccountBalance(fromAccNo);
			double balance = accountDto.getAccountBalance();
			if(balance>transactionsDto.getAmount()) {
				transactions.setDateOfTransaction( Calendar.getInstance());
				transactions.setTransactionStatus(TransactionStatus.SUCCESS);
				transactions.setDescription("Transaction complete");
				transactionDao.save(transactions);
				accountDao.deposit(transactionsDto.getAmount(), toAccNo);
				accountDao.withdraw(transactionsDto.getAmount(), fromAccNo);
				return transactions;
			}else {
				System.out.println("Insufficient balance");
				transactions.setDateOfTransaction( Calendar.getInstance());
				transactions.setTransactionStatus(TransactionStatus.FAILED);
				transactions.setDescription("Transaction incomplete");
				transactionDao.save(transactions);
				return null;
			}
		}
		else {
			System.out.println("Some error occured");
			transactions.setDateOfTransaction( Calendar.getInstance());
			transactions.setTransactionStatus(TransactionStatus.FAILED);
			transactions.setDescription("Transaction incomplete");
			transactionDao.save(transactions);
			return null;
		}
		
	}
	
	@Override
	public Transactions fundTransferCustomer(TransactionsDTO transactionsDto) {
		Transactions transactions = new Transactions();
		Account account1 = new Account();
		Account account2 = new Account();
		transactions.setAmount(transactionsDto.getAmount());
		long fromAccNo = transactionsDto.getFromAccount();
		account1.setAccountNumber(fromAccNo);
		transactions.setFromAccount(account1);
		long toAccNo = transactionsDto.getToAccount();
		account2.setAccountNumber(toAccNo);
		transactions.setToAccount(account2);
		boolean flag1 = accountDao.existsById(fromAccNo);
		boolean flag2 = accountDao.existsById(toAccNo);
		if(flag1==true && flag2==true) {
			AccountDTO accountDto = accountDao.getAccountBalance(fromAccNo);
			double balance = accountDto.getAccountBalance();
			if(balance>transactionsDto.getAmount()) {
				transactions.setDateOfTransaction( Calendar.getInstance());
				transactions.setTransactionStatus(TransactionStatus.SUCCESS);
				transactions.setDescription("Transaction complete");
				transactionDao.save(transactions);
				accountDao.deposit(transactionsDto.getAmount(), toAccNo);
				accountDao.withdraw(transactionsDto.getAmount(), fromAccNo);
				return transactions;
			}else {
				System.out.println("Insufficient balance");
				transactions.setDateOfTransaction( Calendar.getInstance());
				transactions.setTransactionStatus(TransactionStatus.FAILED);
				transactions.setDescription("Transaction incomplete");
				transactionDao.save(transactions);
				return null;
			}
		}
		else {
			System.out.println("Some error occured");
			transactions.setDateOfTransaction( Calendar.getInstance());
			transactions.setTransactionStatus(TransactionStatus.FAILED);
			transactions.setDescription("Transaction incomplete");
			transactionDao.save(transactions);
			return null;
		}
		
	}


	@Override
	public List<Transactions> getAllTransactionsByAccountNumber(long accountNumber) {
		return transactionDao.getAllTransactionsByAccountNumber(accountNumber);
	}

	

	

	

}

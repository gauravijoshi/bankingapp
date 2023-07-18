package com.xoriant.banking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.DTO.TransactionsDTO;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.model.Transactions;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.repository.TransactionDao;
import com.xoriant.banking.service.AccountService;
import com.xoriant.banking.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {

	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/addTransactions")
	public ResponseEntity<?> addTransactions(@RequestBody TransactionsDTO transactionsDto) {
		AccountDTO accountDTO = accountService.getAccountBalance(transactionsDto.getFromAccount());
		if(!accountDao.existsById(transactionsDto.getFromAccount())) {
			return new ResponseEntity<>("Please enter valid from account number", HttpStatus.OK);
		}else if(!accountDao.existsById(transactionsDto.getToAccount())) {
			return new ResponseEntity<>("Please enter valid to account number", HttpStatus.OK);
		}else if(accountDao.getAccountStatus(transactionsDto.getFromAccount())==Status.INACTIVE || accountDao.getAccountStatus(transactionsDto.getToAccount())==Status.INACTIVE) {
			return new ResponseEntity<>("Provided account number is currently inactive", HttpStatus.OK);
		}else if(transactionsDto.getAmount()>accountDTO.getAccountBalance()) {
			return new ResponseEntity<>("Insufficient balance", HttpStatus.OK);
		}else {
			transactionService.fundTransfer(transactionsDto);
			return new ResponseEntity<>("Transaction successful", HttpStatus.OK);
		}
	}
	
	@PostMapping("/addTransactionsCustomer")
	public ResponseEntity<?> addTransactionsCustomer(@RequestBody TransactionsDTO transactionsDto) {
		List<Long> list=accountService.getAccountNumberByPersonId();
		AccountDTO accountDTO = accountService.getAccountBalance(transactionsDto.getFromAccount());
		if(!accountDao.existsById(transactionsDto.getToAccount())) {
			return new ResponseEntity<>("Please enter valid to account number", HttpStatus.OK);
		}else if(accountDao.getAccountStatus(transactionsDto.getFromAccount())==Status.INACTIVE || accountDao.getAccountStatus(transactionsDto.getToAccount())==Status.INACTIVE) {
			return new ResponseEntity<>("Provided account number is currently inactive", HttpStatus.OK);
		}else if(transactionsDto.getAmount()>accountDTO.getAccountBalance()) {
			return new ResponseEntity<>("Insufficient balance", HttpStatus.OK);
		}else if(list.contains(transactionsDto.getFromAccount())) {
			transactionService.fundTransfer(transactionsDto);
			return new ResponseEntity<>("Transaction successful", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Please enter valid from account", HttpStatus.OK);
		}
	}
	
	@GetMapping("/getTransaction/{accountNumber}")
	public List<Transactions> getTransaction(@PathVariable long accountNumber) {
		return transactionService.getAllTransactionsByAccountNumber(accountNumber);
	}
	
	@GetMapping("/getCustomerTransaction/{accountNumber}")
	public ResponseEntity<?> getCustomerTransaction(@PathVariable long accountNumber) {
		List<Long> list=accountService.getAccountNumberByPersonId();
		if(list.contains(accountNumber)) {
		    List<Transactions> result = transactionService.getAllTransactionsByAccountNumber(accountNumber);
		    return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
}

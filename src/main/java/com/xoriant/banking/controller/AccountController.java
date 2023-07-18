package com.xoriant.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.DTO.AddAccountDTO;
import com.xoriant.banking.DTO.AmountDTO;
import com.xoriant.banking.DTO.EditAccountDTO;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.repository.UserDao;
import com.xoriant.banking.service.AccountService;
import com.xoriant.banking.service.PersonalInfoService;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PersonalInfoService personalInfoService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/addAccount")
	public ResponseEntity<?> addAccount(@RequestBody AddAccountDTO addAccountDTO) {
		if(addAccountDTO.getUserId()==0 || addAccountDTO.getMinimumBalance()==0 || addAccountDTO.getAccountBalance()==0 || addAccountDTO.getDescription()==null || addAccountDTO.getAccountType()==null || addAccountDTO.getDate()==null) {
			return new ResponseEntity<>("Please enter all required fields", HttpStatus.OK);
		}else if(!userDao.existsById(addAccountDTO.getUserId())){
			return new ResponseEntity<>("Please enter valid user id", HttpStatus.OK);
		}else {
			accountService.addAccount(addAccountDTO);
			return new ResponseEntity<>("Account added successfully", HttpStatus.OK);
		}
	}
	
	@GetMapping("/getBalance/{accountNumber}")
	public ResponseEntity<?> getBalance(@PathVariable long accountNumber) {
		if(!accountDao.existsById(accountNumber)) {
			return new ResponseEntity<>("Please enter valid account number", HttpStatus.OK);
		}else if(accountDao.getAccountStatus(accountNumber)==Status.INACTIVE) {
			return new ResponseEntity<>("Provided account number is currently inactive", HttpStatus.OK);
		}else {
			AccountDTO result = accountService.getAccountBalance(accountNumber);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getCustomerBalance/{accountNumber}")
	public ResponseEntity<?> getCustomerBalance(@PathVariable long accountNumber) {
		List<Long> list=accountService.getAccountNumberByPersonId();
			if(list.contains(accountNumber)) {
				System.out.println(accountDao.getAccountBalance(accountNumber));
			    AccountDTO result = accountService.getAccountBalance(accountNumber);
			    return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
	}
	
	@PutMapping("/deposit/{accountNumber}")
	public ResponseEntity<?> deposit(@PathVariable long accountNumber, @RequestBody AmountDTO amount) {
		if(!accountDao.existsById(accountNumber)) {
			return new ResponseEntity<>("Please enter valid account number", HttpStatus.OK);
		}else if(accountDao.getAccountStatus(accountNumber)==Status.INACTIVE) {
			return new ResponseEntity<>("Provided account number is currently inactive", HttpStatus.OK);
		}else{
			accountService.deposit(amount.getAmount(), accountNumber);
			return new ResponseEntity<>("Amount deposited successfully",HttpStatus.OK);
		}
	}
	
	@PutMapping("/withdraw/{accountNumber}")
	public ResponseEntity<?> withdraw(@PathVariable long accountNumber, @RequestBody AmountDTO amount) {
		AccountDTO accountDTO = accountDao.getAccountBalance(accountNumber);
		if(!accountDao.existsById(accountNumber)) {
			return new ResponseEntity<>("Please enter valid account number", HttpStatus.OK);
		}else if(accountDao.getAccountStatus(accountNumber)==Status.INACTIVE) {
			return new ResponseEntity<>("Provided account number is currently inactive", HttpStatus.OK);
		}else if(amount.getAmount()>accountDTO.getAccountBalance()) {
			return new ResponseEntity<>("Insufficient balance", HttpStatus.OK);
		}else {
			accountService.withdraw(amount.getAmount(), accountNumber);
			return new ResponseEntity<>("Amount withdrawn successfully", HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/deleteAccount/{accountNumber}")
	public ResponseEntity<?> deleteAccount(@PathVariable long accountNumber) {
		System.out.println(accountNumber);
//		if(accountNumber==0) {
//			return new ResponseEntity<>("Please enter account number", HttpStatus.OK);
//		}else if(!accountDao.existsById(accountNumber)) {
//			System.out.println("check");
//			return new ResponseEntity<>("Please enter valid account number", HttpStatus.OK);
//		}else if(accountDao.getAccountStatus(accountNumber)==Status.INACTIVE) {
//			return new ResponseEntity<>("Provided account number is already inactive", HttpStatus.OK);
//		}else {
			accountService.deleteAccount(accountNumber);
			return new ResponseEntity<>("Account has been deactivated", HttpStatus.OK);
//		}
	}
	
	@PutMapping("/editAccount")
	public ResponseEntity<?> editAccount(@RequestBody EditAccountDTO editAccountDTO) {
		if(editAccountDTO.getAccountNumber()==0 || editAccountDTO.getMinimumBalance()==0 || editAccountDTO.getDescription()==null || editAccountDTO.getAccountType()==null || editAccountDTO.getDate()==null) {
			return new ResponseEntity<>("Please enter all required fields", HttpStatus.OK);
		}else if(!accountDao.existsById(editAccountDTO.getAccountNumber())) {
			return new ResponseEntity<>("Please enter valid account number", HttpStatus.OK);
		}else if(accountDao.getAccountStatus(editAccountDTO.getAccountNumber())==Status.INACTIVE) {
			return new ResponseEntity<>("Provided account number is currently inactive", HttpStatus.OK);
		}
		else{
			accountService.editAccount(editAccountDTO);
			return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
		}
	}
}

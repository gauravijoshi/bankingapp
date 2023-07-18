package com.xoriant.banking.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.DTO.AddAccountDTO;
import com.xoriant.banking.DTO.EditAccountDTO;
import com.xoriant.banking.DTO.PersonDTO;
import com.xoriant.banking.mapper.AccountMapper;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.repository.PersonalInfoDao;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	PersonalInfoService personalInfoService; 
	
	@Autowired
	PersonalInfoDao personalInfoDao;
	
	@Autowired
	AccountMapper accountMapper;
	
	Account account;
	
	@Override
	public AccountDTO getAccountBalance(long accountNumber) {
		return accountDao.getAccountBalance(accountNumber);
	}
	
	@Override
	public Account deposit(double amount, long accountNumber) {
		accountDao.deposit(amount, accountNumber);
        return accountDao.findById(accountNumber).get();
    }
     
	@Override
    public Account withdraw(double amount, long accountNumber){
		AccountDTO accountDTO = accountDao.getAccountBalance(accountNumber);
		double balance = accountDTO.getAccountBalance();
		if(balance>amount) {
	    	accountDao.withdraw(amount, accountNumber);
	        return accountDao.findById(accountNumber).get();
		}
		else {
			System.out.println("Insufficient balance");
			return null;
		}
    } 

	@Override
	public Account deleteAccount(long accountNumber) {
		Status accountStatus = Status.INACTIVE;
		Calendar dateOfClosure = Calendar.getInstance();
		accountDao.deleteAccount(accountStatus, dateOfClosure, accountNumber);
        return accountDao.findById(accountNumber).get();
	}
	
	@Override
	public Account editAccount(EditAccountDTO editAccountDTO) {
	    Account account = accountDao.findById(editAccountDTO.getAccountNumber()).orElse(null);
	    accountMapper.updateAccountFromDto(editAccountDTO, account);
	    return accountDao.save(account);
	}

	@Override
	public List<Long> getAccountNumberByPersonId() {
		PersonDTO personDTO = personalInfoService.getPersonId();
		int personId = personDTO.getPersonId();
		System.out.println(personId);
		return accountDao.getCustomerBalance(personId);
	}

	@Override
	public Account addAccount(AddAccountDTO addAccountDTO) {
		PersonDTO personDTO = personalInfoDao.getPersonId(addAccountDTO.getUserId());
		int personId = personDTO.getPersonId();
		Customer customer = new Customer();
		customer.setPersonId(personId);
		Account account = new Account();
		account.setCustomer(customer);
		account.setAccountBalance(addAccountDTO.getAccountBalance());
		account.setMinimumBalance(addAccountDTO.getMinimumBalance());
		account.setAccountStatus(Status.ACTIVE);
		account.setDate(addAccountDTO.getDate());
		account.setDescription(addAccountDTO.getDescription());
		account.setAccountType(addAccountDTO.getAccountType());
		return accountDao.save(account);
	}

}

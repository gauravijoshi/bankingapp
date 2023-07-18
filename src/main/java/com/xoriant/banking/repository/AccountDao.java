package com.xoriant.banking.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Status;

public interface AccountDao extends JpaRepository<Account, Long>{

	@Query(value="select new com.xoriant.banking.DTO.AccountDTO(a.accountBalance) from Account a where a.accountNumber=?1")
	AccountDTO getAccountBalance(long accountNumber);
	
	@Query(value="update Account a set a.accountBalance = a.accountBalance + ?1 where a.accountNumber = ?2")
	@Modifying
	@Transactional
	public void deposit(double amount, long accountNumber);
	     
	@Query(value="update Account a set a.accountBalance = a.accountBalance - ?1 where a.accountNumber = ?2")
	@Modifying
	@Transactional
	public void withdraw(double amount, long accountNumber);
	
	@Query(value="update Account a set a.accountStatus = ?1, a.dateOfClosure=?2 where a.accountNumber = ?3")
	@Modifying
	@Transactional
	public void deleteAccount(Status accountStatus, Calendar dateOfClosure, long accountNumber);
	
	@Query(value="select a.accountNumber from Account a where a.customer.personId=?1")
	List<Long> getCustomerBalance(int personId);
	
	@Query(value="select a.accountStatus from Account a where a.accountNumber=?1")
	Status getAccountStatus(long accountNumber);
}

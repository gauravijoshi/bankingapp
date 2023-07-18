package com.xoriant.banking.service;

import java.util.List;

import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.DTO.AddAccountDTO;
import com.xoriant.banking.DTO.EditAccountDTO;
import com.xoriant.banking.model.Account;

public interface AccountService {

	AccountDTO getAccountBalance(long accountNumber);
	List<Long> getAccountNumberByPersonId();
	Account deposit(double amount, long accountNumber);
    Account withdraw(double amount, long accountNumber);
    Account deleteAccount(long accountNumber);
    Account editAccount(EditAccountDTO editAccountDTO);
    public Account addAccount(AddAccountDTO addAccountDTO);
}

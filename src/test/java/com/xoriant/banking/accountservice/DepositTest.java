package com.xoriant.banking.accountservice;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.DTO.AmountDTO;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.service.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {

	@Mock
	private AccountDao accountDao;
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	
	@org.junit.Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
//	@Test
//	public void deposit_TakeDoubleAmountLongAccountNumber_ReturnAccount() {
//		Account account = new Account();
//		account.setAccountNumber(2);
//		double amount = 1000;
//		long accountNumber = 2;
//		Account result = accountServiceImpl.deposit(amount, accountNumber);
//		Assert.assertEquals(result, account);
//	}

	@Test
	public void deposit_TakeDoubleAmountLongAccountNumber_ReturnVoid() {
		
	}
}

package com.xoriant.banking.accountservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.xoriant.banking.DTO.AccountDTO;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.service.AccountServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

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
	
	@Test
	public void getAccountBalance_TakeLongAccountNumber_ReturnAccountDTO() {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountBalance(34304);
		Long accountNumber = 2l;
		Mockito.when(accountDao.getAccountBalance(any(Long.class))).thenReturn(accountDTO);
		AccountDTO result = accountServiceImpl.getAccountBalance(accountNumber);
		Assert.assertEquals(result, accountDTO);
	}
	
	@Test
	public void deposit_TakeDoubleAmountLongAccountNumber_ReturnAccount() {
		
	}
	
}

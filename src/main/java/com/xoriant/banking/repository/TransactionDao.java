package com.xoriant.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xoriant.banking.DTO.TransactionsDTO;
import com.xoriant.banking.model.Transactions;

public interface TransactionDao extends JpaRepository<Transactions, Integer > {
	
	@Query(value="select t from Transactions t where t.fromAccount.accountNumber=?1")
	List<Transactions> getAllTransactionsByAccountNumber(long accountNumber);

	void save(TransactionsDTO transactionsDto);
}
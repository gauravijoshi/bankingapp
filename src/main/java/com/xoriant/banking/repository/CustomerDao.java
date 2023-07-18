package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Status;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	@Query(value="update Customer c set c.customerStatus = ?1 where c.personId = ?2")
	@Modifying
	@Transactional
	public void deleteCustomer(Status customerStatus, int personId);
	
}

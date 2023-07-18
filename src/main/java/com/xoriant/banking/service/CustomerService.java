package com.xoriant.banking.service;

import com.xoriant.banking.DTO.CustomerDTO;
import com.xoriant.banking.DTO.EditCustomerDTO;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Status;

public interface CustomerService {

	Customer deleteCustomer(Status CustomerStatus, int personId);
	public Customer addCustomer(CustomerDTO customerDTO);
	Customer updateCustomer(EditCustomerDTO editCustomerDTO);
}

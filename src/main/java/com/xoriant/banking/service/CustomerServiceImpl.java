package com.xoriant.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.banking.DTO.CustomerDTO;
import com.xoriant.banking.DTO.EditCustomerDTO;
import com.xoriant.banking.mapper.CustomerMapper;
import com.xoriant.banking.model.Address;
import com.xoriant.banking.model.Branch;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Manager;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public Customer deleteCustomer(Status CustomerStatus, int personId) {
		customerDao.deleteCustomer(CustomerStatus, personId);
	    return customerDao.findById(personId).get();
	}

//	@Override
//	public void updateCustomer(int personId) {
//		customerDao.existsById(personId);
//	}

	@Override
	public Customer updateCustomer(EditCustomerDTO editCustomerDTO) {
	    Customer customer = customerDao.findById(editCustomerDTO.getPersonId()).orElse(null);
	    customerMapper.updateCustomerFromDto(editCustomerDTO, customer);
	    return customerDao.save(customer);
	}
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Address address = new Address();
		address.setFlatNo(customerDTO.getFlatNo());
		address.setCity(customerDTO.getCity());
		address.setState(customerDTO.getState());
		address.setPincode(customerDTO.getPincode());
		
		Branch branch = new Branch();
		branch.setBranchName(customerDTO.getBranchName());
		branch.setIFSC(customerDTO.getIFSC());
		
		User user = new User();
		user.setUserName(customerDTO.getUserName());
		user.setPassword(customerDTO.getPassword());
		user.setRole("CUSTOMER");
		
		Manager manager = new Manager();
		manager.setPersonId(1);
		
		Customer customer = new Customer();
		customer.setPersonName(customerDTO.getPersonName());
		customer.setGender(customerDTO.getGender());
		customer.setDob(customerDTO.getDob());
		customer.setEmail(customerDTO.getEmail());
		customer.setTelephoneNumber(customerDTO.getTelephoneNumber());
		customer.setAddress(address);
		customer.setBranch(branch);
		customer.setUser(user);
		customer.setCustomerStatus(Status.ACTIVE);
		
		return customerDao.save(customer);
	}

}

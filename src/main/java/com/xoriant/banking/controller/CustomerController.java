package com.xoriant.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.DTO.CustomerDTO;
import com.xoriant.banking.DTO.EditCustomerDTO;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.repository.CustomerDao;
import com.xoriant.banking.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
		if(customerDTO.getPersonName()==null || customerDTO.getTelephoneNumber()==null || customerDTO.getDob()==null || customerDTO.getEmail()==null || customerDTO.getGender()==null || customerDTO.getUserName()==null || customerDTO.getPassword()==null || customerDTO.getBranchName()==null || customerDTO.getIFSC()==null || customerDTO.getFlatNo()==0 || customerDTO.getCity()==null || customerDTO.getState()==null || customerDTO.getPincode()==0) {
			return new ResponseEntity<>("Please enter required information in all fields", HttpStatus.OK);
		}else {
			customerService.addCustomer(customerDTO);
			return new ResponseEntity<>("Customer added successfully", HttpStatus.OK);
		}
	}
	
	@PutMapping("/deleteCustomer/{personId}")
	public void deleteCustomer(@PathVariable int personId, @RequestBody Customer customer) {
		customerService.deleteCustomer(customer.getCustomerStatus(), personId);
	}
	
	@PutMapping("/editCustomer")
	public ResponseEntity<?> editCustomer(@RequestBody EditCustomerDTO editCustomerDTO) {
		if(editCustomerDTO.getPersonId()==0 || editCustomerDTO.getPersonName()==null || editCustomerDTO.getTelephoneNumber()==null || editCustomerDTO.getDob()==null || editCustomerDTO.getEmail()==null || editCustomerDTO.getGender()==null  || editCustomerDTO.getBranchName()==null || editCustomerDTO.getIFSC()==null || editCustomerDTO.getFlatNo()==0 || editCustomerDTO.getCity()==null || editCustomerDTO.getState()==null || editCustomerDTO.getPincode()==0) {
			return new ResponseEntity<>("Please enter required information in all fields", HttpStatus.OK);
		}else if(!customerDao.existsById(editCustomerDTO.getPersonId())){
			return new ResponseEntity<>("Please enter valid person id", HttpStatus.OK);
		}
		else {
			customerService.updateCustomer(editCustomerDTO);
			return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
		}
	}
}

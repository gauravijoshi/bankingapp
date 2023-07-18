package com.xoriant.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.model.Address;
import com.xoriant.banking.repository.AddressDao;

@RestController
@CrossOrigin(origins = "*")
public class AddressController {

	@Autowired
	AddressDao addressDao;
	
	@PostMapping("/addAddress")
	public void addAddress(@RequestBody Address address) {
		System.out.println(address);
		addressDao.save(address);
	}
}

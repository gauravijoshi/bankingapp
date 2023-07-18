package com.xoriant.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.model.Manager;
import com.xoriant.banking.model.PersonalInfo;
import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.ManagerDao;

@RestController
@CrossOrigin(origins = "*")
public class ManagerController {

	@Autowired
	ManagerDao managerDao;
	
	User user;
	PersonalInfo personalInfo;
	
	@PostMapping("/addManager")
	public void addManager(@RequestBody Manager manager) {
		System.out.println(manager);
			managerDao.save(manager);
	}
}

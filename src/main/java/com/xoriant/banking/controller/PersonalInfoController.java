package com.xoriant.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.model.PersonalInfo;
import com.xoriant.banking.repository.ManagerDao;
import com.xoriant.banking.repository.PersonalInfoDao;
import com.xoriant.banking.service.PersonalInfoService;

@RestController
@CrossOrigin(origins = "*")
public class PersonalInfoController {
	
	@Autowired
	PersonalInfoDao personalInfoDao;
	
	@Autowired 
	PersonalInfoService personalInfoSerive;
	
	@Autowired
	ManagerDao managerDao;
	
	@PostMapping("/addPerson")
	public void addPerson(@RequestBody PersonalInfo personalInfo) {
		personalInfoDao.save(personalInfo);
	}
	
	@GetMapping("/getAllCustomers")
	public List<PersonalInfo> getAllCustomers() {
		return personalInfoSerive.getAllCustomers();
	}

}

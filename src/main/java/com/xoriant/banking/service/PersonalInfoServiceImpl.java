package com.xoriant.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.banking.DTO.PersonDTO;
import com.xoriant.banking.model.PersonalInfo;
import com.xoriant.banking.repository.PersonalInfoDao;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{

	@Autowired
	private PersonalInfoDao personalInfoDao;
	
	@Override
	public PersonDTO getPersonId() {
		return personalInfoDao.getPersonId(UserServiceImpl.id);
	}

	@Override
	public List<PersonalInfo> getAllCustomers() {
		String role="CUSTOMER";
		return personalInfoDao.getAllCustomers(role);
	}

}

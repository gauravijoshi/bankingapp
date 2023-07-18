package com.xoriant.banking.service;

import java.util.List;

import com.xoriant.banking.DTO.PersonDTO;
import com.xoriant.banking.model.PersonalInfo;

public interface PersonalInfoService {

	PersonDTO getPersonId();
	List<PersonalInfo> getAllCustomers();
}

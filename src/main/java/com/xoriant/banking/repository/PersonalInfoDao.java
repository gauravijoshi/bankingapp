package com.xoriant.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xoriant.banking.DTO.PersonDTO;
import com.xoriant.banking.model.PersonalInfo;

public interface PersonalInfoDao extends JpaRepository<PersonalInfo, Integer> {

	
	@Query(value="select new com.xoriant.banking.DTO.PersonDTO(p.personId) from PersonalInfo p where p.user.userId=?1")
	public PersonDTO getPersonId(int userId);
	
	@Query(value="select p from PersonalInfo p where p.user.role=?1")
	List<PersonalInfo> getAllCustomers(String role);
}

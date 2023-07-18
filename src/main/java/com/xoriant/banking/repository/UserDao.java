package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.banking.model.User;

public interface UserDao  extends JpaRepository<User, Integer>{
	
	
	  public User findByUserId(Integer userId);
	  
	  User findByUserName(String userName); 
}

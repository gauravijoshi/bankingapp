package com.xoriant.banking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.UserDao;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	
	public static int id;
	
	@Autowired
	UserDao userDao;
	
	AccountServiceImpl accountServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

	@Override
	public User login(String userName, String password) {
		User user = userDao.findByUserName(userName);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				id = user.getUserId();
				return user;
			}else {
				return null;
			}
		}
		return null;
	}
}

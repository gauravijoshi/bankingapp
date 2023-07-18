package com.xoriant.banking.DTO;

import com.xoriant.banking.model.User;

public class LoginDTO {
	private  User user;
	private String JWT;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getJWT() {
		return JWT;
	}
	public void setJWT(String jWT) {
		JWT = jWT;
	}
	
	

}

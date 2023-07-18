package com.xoriant.banking.DTO;

import javax.validation.constraints.NotNull;

public class UserDTO {

	private int userId;
	@NotNull(message = "User name is required")
	private String userName;
	@NotNull(message = "Password is required")
	private String password;
	
	public UserDTO() {
		
	}

	public UserDTO(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

package com.xoriant.banking.DTO;

import java.util.Calendar;

import com.xoriant.banking.model.Gender;

public class CustomerDTO {
	
	private String personName;
	private String telephoneNumber;
	private Calendar dob;
	private String email;
	private Gender gender;
	private String userName;
	private String password;
	private String branchName;
	private String IFSC;
	private int flatNo;
	private String city;
	private String state;
	private int pincode;
	
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String personName, String telephoneNumber, Calendar dob, String email, Gender gender,
			String userName, String password, String branchName, String iFSC, int flatNo, String city,
			String state, int pincode) {
		super();
		this.personName = personName;
		this.telephoneNumber = telephoneNumber;
		this.dob = dob;
		this.email = email;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
		this.branchName = branchName;
		IFSC = iFSC;
		this.flatNo = flatNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	

}

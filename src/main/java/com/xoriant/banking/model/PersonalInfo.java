package com.xoriant.banking.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int personId;
	protected String personName;
	protected String telephoneNumber;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	protected Calendar dob;
	protected String email;
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	protected User user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="branchId")
	protected Branch branch;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	protected Address address;



}

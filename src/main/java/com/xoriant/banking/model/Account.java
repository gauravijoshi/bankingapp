package com.xoriant.banking.model;


import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@JsonIgnoreProperties({"customer", "transaction"})
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountNumber;
	@ManyToOne
	@JoinColumn(name="personId")
	private Customer customer;
	private double accountBalance;
	private double minimumBalance;
	private Status accountStatus;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar date;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar dateOfClosure;
	private String description;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "fromAccount")
	private List<Transactions> transaction;
	
}

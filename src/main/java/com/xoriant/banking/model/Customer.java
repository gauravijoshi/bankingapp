package com.xoriant.banking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties("account")
public class Customer extends PersonalInfo {
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "managerId")
	private Manager manager;
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
	private List<Account> account;
	@Enumerated(EnumType.STRING)
	private Status customerStatus;
}

	

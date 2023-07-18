	package com.xoriant.banking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties("customer")
public class Manager extends PersonalInfo {
	@OneToMany(mappedBy = "manager",cascade = CascadeType.PERSIST)
	private List<Customer> customer;

	
}

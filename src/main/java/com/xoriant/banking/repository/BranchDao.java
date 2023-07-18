package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.banking.model.Branch;

public interface BranchDao extends JpaRepository<Branch, Integer>{


}

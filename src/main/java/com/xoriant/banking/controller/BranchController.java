package com.xoriant.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.model.Branch;
import com.xoriant.banking.repository.BranchDao;

@RestController
@CrossOrigin(origins = "*")
public class BranchController {

	@Autowired
	BranchDao branchDao;
	
	@PostMapping("/addBranch")
	public void addBranch(@RequestBody Branch branch) {
		System.out.println(branch);
		branchDao.save(branch);
	}
}

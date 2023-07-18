package com.xoriant.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.banking.DTO.UserDTO;
import com.xoriant.banking.aop.LogAspect;
import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.UserDao;
import com.xoriant.banking.service.UserService;
import com.xoriant.banking.util.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	LogAspect logAspect;

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	UserDTO userDTO;
	
	@GetMapping("/")
	public String login() {
		return "Welcome";
	}
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {
		System.out.println(user);
		userDao.save(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginS(@Valid @RequestBody UserDTO userDTO) {
		logAspect.logAroundUserName(null);
		User user= userService.login(userDTO.getUserName(), userDTO.getPassword());
		if(userDTO.getUserName()==null || userDTO.getPassword()==null) {
			return new ResponseEntity<String>("Please provide username and password",HttpStatus.OK);			
		}else if(user==null) {
			return new ResponseEntity<String>("Username and password does not match",HttpStatus.OK);			
		}else {
			if(user.getRole().equals("MANAGER")) {
				String result= jwtUtil.generateToken(userDTO.getUserName());
				return new ResponseEntity<String>("MANAGER-"+result,HttpStatus.OK);
			}else {
				String result= jwtUtil.generateToken(userDTO.getUserName());
				return new ResponseEntity<String>("CUSTOMER"+result,HttpStatus.OK);
			}
		}
	}
		
//		@PostMapping("/login")
//		public ResponseEntity<LoginDTO> loginS(@RequestBody UserDTO userDTO) {
//			logAspect.logAroundUserName(null);
//			System.out.println("DTO"+ userDTO.getUserId());
//			User user= userService.login(userDTO.getUserName(), userDTO.getPassword(), userDTO.getUserId());
//			if(user==null) {
//			//	return new Exception("Invalid username or password");
//				return null;			
//			}else {
//				LoginDTO loginInfo=new LoginDTO();
//					String result= jwtUtil.generateToken(userDTO.getUserName());
//					loginInfo.setUser(user);
//					loginInfo.setJWT(result);
//					return new ResponseEntity<LoginDTO>(loginInfo,HttpStatus.OK);
//				}
//			}
	
}



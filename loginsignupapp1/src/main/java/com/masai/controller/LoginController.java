package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.CustomerDTO;
import com.masai.model.RestaurantDTO;
import com.masai.service.CustomerLoginServiceImpl;
import com.masai.service.RestaurantLoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	private CustomerLoginServiceImpl userLogInServiceImpl;

	@Autowired
	private RestaurantLoginServiceImpl adminLogInServiceImpl;

	// for user login
	@PostMapping("/userlogin")
	public String logInUser(@RequestBody CustomerDTO userDTO) throws Exception {
		return userLogInServiceImpl.logIntoAccount(userDTO);
	}

	// for user logout
	@PatchMapping("/userlogout")
	public String logOutUser(@RequestParam(required = false) String key) {
		return userLogInServiceImpl.logOutAccount(key);
	}

	// for admin login
	@PostMapping("/adminlogin")
	public String logInAdmin(@RequestBody RestaurantDTO adminDTO) {
		return adminLogInServiceImpl.logIntoAccount(adminDTO);
	}

	// for admin logout
	@PatchMapping("/adminlogout")
	public String logOutAdmin(@RequestParam(required = false) String key) {
		return adminLogInServiceImpl.logOutAccount(key);
	}
	
	

}

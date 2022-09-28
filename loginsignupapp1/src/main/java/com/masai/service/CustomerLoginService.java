package com.masai.service;

import com.masai.model.CustomerDTO;

public interface CustomerLoginService {
	
    public String logIntoAccount(CustomerDTO customerDTO) throws Exception;
	
	public String logOutAccount(String key);
	

}

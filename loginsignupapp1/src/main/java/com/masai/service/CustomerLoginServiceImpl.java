package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.model.CustomerAdminSession;
import com.masai.model.CustomerDTO;
import com.masai.model.RestaurantAdminSession;
import com.masai.repositry.CustomerAdminSessionDao;
import com.masai.repositry.CustomerDao;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private CustomerAdminSessionDao customerAdminSessionDao;

	@Override
	public String logIntoAccount(CustomerDTO customerDTO) throws Exception {
		// TODO Auto-generated method stub
		
     Optional<Customer> opt= customerdao.findByMobileNo(customerDTO.getMobileNo());
		
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		Customer user1= opt.get();
		String userId = user1.getCustomerId();
		Optional<CustomerAdminSession>  currUseropt1= customerAdminSessionDao.findByUserId(userId);
		
		if(currUseropt1.isPresent()) {
			return "Customer already logged in with this number.";
		}
		
		if(user1.getPassword().equals(customerDTO.getPassword())) {
			
			String key = RandomString.make(6);
			CustomerAdminSession currentUserSession = new CustomerAdminSession(userId, key, LocalDateTime.now());
			
			
			customerAdminSessionDao.save(currentUserSession);
		
			return currentUserSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}
	}

	@Override
	public String logOutAccount(String key) {
		// TODO Auto-generated method stub
      Optional<CustomerAdminSession> currUserOpt=customerAdminSessionDao.findByUuid(key);
		
		if(currUserOpt.isPresent()) {
			CustomerAdminSession currUser1=currUserOpt.get();
			
			customerAdminSessionDao.delete(currUser1);
			return "User logged out successfully.";
		}
		return "User does not exist, Enter correct uuid";

	}
}

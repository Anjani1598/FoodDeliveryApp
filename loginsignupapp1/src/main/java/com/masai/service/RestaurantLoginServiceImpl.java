package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Restaurant;
import com.masai.model.RestaurantAdminSession;
import com.masai.model.RestaurantDTO;
import com.masai.repositry.RestaurantAdminSessionDao;
import com.masai.repositry.RestaurantDao;

import net.bytebuddy.utility.RandomString;

@Service
public class RestaurantLoginServiceImpl implements RestaurantLoginService{
	
	
	@Autowired
	private RestaurantDao restaurantdao;
	
	@Autowired
	private RestaurantAdminSessionDao restaurantadminsessiondao;

	@Override
	public String logIntoAccount(RestaurantDTO restaurantDTO) {
		// TODO Auto-generated method stub
		
        Optional<Restaurant> opt= restaurantdao.findByMobileNo(restaurantDTO.getMobileNo());
		
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		Restaurant admin1= opt.get();
		String userId = admin1.getRestaurantId();
		Optional<RestaurantAdminSession>  currAdminopt1= restaurantadminsessiondao.findByAdminId(userId);
		
		if(currAdminopt1.isPresent()) {
			return "REstaurent Admin already logged in with this number.";
		}
		
		if(admin1.getPassword().equals(restaurantDTO.getPassword())) {
			
			String key = RandomString.make(6);
			RestaurantAdminSession currentAdminSession = new RestaurantAdminSession(userId, key, LocalDateTime.now());
			
			
			restaurantadminsessiondao.save(currentAdminSession);
			
			return currentAdminSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}
		
	}

	@Override
	public String logOutAccount(String key) {
		// TODO Auto-generated method stub
		
		
        Optional<RestaurantAdminSession> currAdminOpt=restaurantadminsessiondao.findByUuid(key);
		
		if(currAdminOpt.isPresent()) {
			RestaurantAdminSession currAdmin1=currAdminOpt.get();
			
			restaurantadminsessiondao.delete(currAdmin1);
			return "Admin logged out successfully.";
		}
		return "Admin does not exist, Enter correct uuid";
	}
		
		
	}

	

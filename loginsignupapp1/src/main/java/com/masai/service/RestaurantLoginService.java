package com.masai.service;

import com.masai.model.RestaurantDTO;

public interface RestaurantLoginService {
	
    public String logIntoAccount(RestaurantDTO restaurantDTO);
	
	public String logOutAccount(String key);
	

}

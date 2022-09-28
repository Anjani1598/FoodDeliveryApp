package com.masai.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{
	
	public Optional<Restaurant> findByMobileNo(String mobileNo);

}

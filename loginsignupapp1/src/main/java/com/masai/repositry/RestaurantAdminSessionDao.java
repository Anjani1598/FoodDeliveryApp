package com.masai.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.masai.model.RestaurantAdminSession;

@Service
public interface RestaurantAdminSessionDao extends JpaRepository<RestaurantAdminSession, Integer>{

	
     public Optional<RestaurantAdminSession> findByAdminId(String userId);
	
	 public Optional<RestaurantAdminSession> findByUuid(String uuid);
	
	
}

package com.masai.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.masai.model.CustomerAdminSession;

@Service
public interface CustomerAdminSessionDao extends JpaRepository<CustomerAdminSession, Integer>{

    public Optional<CustomerAdminSession> findByUserId(String userId);
	
	public Optional<CustomerAdminSession> findByUuid(String uuid);

	
	
}

package com.masai.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> findByMobileNo(String mobileNo);

}

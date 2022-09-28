package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String customerId;
	
	@NotNull(message = "firstName is mandatory")
	private String firstName;
	
	@NotNull(message = "lastName is mandatory")
	private String lastName;
	@Max(100)
	private Integer age;
	@NotNull(message = "gender is mandatory")
	private String gender;
	
	@Column(unique = true)
	@Size(max = 10,min = 10)
	@NotNull(message = "Mobile is mandatory")
	private String mobileNo;
	
	@Email(message="Enter your Email properly")
	@NotNull(message = "Email is mandatory")
	private String email;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	
	

}

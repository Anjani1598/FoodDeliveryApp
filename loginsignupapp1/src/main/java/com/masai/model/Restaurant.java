package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Restaurant {
	
	@Max(1000)
	@Id
	@NotNull(message = "resturantId is mandatory")
	private String restaurantId;
	
	@NotNull(message = "resturantName is mandatory")
	private String restaurantName;
	
	@NotNull(message = "managerName is mandatory")
	private String managerName;
	
	@Column(unique = true)
	@Size(max = 10,min = 10)
	@NotNull(message = "Mobile is mandatory")
	private String mobileNo;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	

}

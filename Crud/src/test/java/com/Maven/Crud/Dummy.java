package com.Maven.Crud;

import com.Maven.Crud.Domain.UserResponse;

public class Dummy {
	
	public UserResponse getUserResponse() {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(1);
		userResponse.setFirstName("Diana");
		userResponse.setLastName("Pinto");
		userResponse.setEmail("DianaP@gmail.com");
		
		return userResponse;
	}
}

package com.Maven.Crud;

import com.Maven.Crud.Domain.UserResponse;

public class Dummy {
	UserResponse userResponse = new UserResponse();
	
	public UserResponse setUserResponse() {
		userResponse.setId(1);
		userResponse.setFirstName("Diana");
		userResponse.setLastName("Pinto");
		userResponse.setEmail("DianaP@gmail.com");
		return userResponse;
	}
}

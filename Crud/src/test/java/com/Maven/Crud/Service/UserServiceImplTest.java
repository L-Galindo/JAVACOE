package com.Maven.Crud.Service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Maven.Crud.Dummy;
import com.Maven.Crud.Domain.UserResponse;

public class UserServiceImplTest {
	@Autowired
	private UserService userService;
	
	Dummy dummy = new Dummy();
	
	@Test
	public void getById() {
		UserResponse userResponse = userService.getById(dummy.setUserResponse().getId());
		assertNotNull(userResponse);
	}
}

package com.Maven.Crud.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.Maven.Crud.Service.UserService;

import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.Maven.Crud.Dummy;
import com.Maven.Crud.Domain.UserResponse;
import com.Maven.Crud.Model.UserResources;


public class UserControllerTest {
	
	@Mock
	private UserService userServiceMock;
	
	@InjectMocks
	private UserController userControllerMock;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	Dummy dummy = new Dummy();
	
	@Test
	public void testGetUsersById() {	
		when(userServiceMock.getById(any(int.class))).thenReturn(new UserResponse());
		UserResponse results = userControllerMock.findUsersbyId(1);
		assertEquals(dummy.getUserResponse(), results);
	}
}

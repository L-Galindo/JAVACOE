package com.Maven.Crud.Controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import com.Maven.Crud.Service.UserService;

import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.Maven.Crud.Dummy;


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
	public void FindUsersById_Should_ReturnNotNull_When_IdIsFound() {	
		when(userServiceMock.getById(any(int.class))).thenReturn(dummy.setUserResponse());
		assertNotNull(userControllerMock.findUsersbyId(Mockito.anyInt()));
	}
	
	@Test
	public void FindUsersById_Shoud_ReturnNull_When_IdDoesntExist() {
		when(userServiceMock.getById(1)).thenReturn(dummy.setUserResponse());
		assertNull(userControllerMock.findUsersbyId(2));
	}
}

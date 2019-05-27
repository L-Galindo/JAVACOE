package com.Maven.Crud.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Maven.Crud.Model.UserResources;

import lombok.var;

public class UserResourcesTest {
	UserResources userResourcesTest = new UserResources();
	
	@Test
	public void getFirstName() {
		userResourcesTest.setFirstName("Luis");
		String expected = "Luis";
		
		var result = userResourcesTest.getFirstName();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void setFirstName() {
		String expected = "Luis";
		
		userResourcesTest.setFirstName("Luis");
		
		assertEquals(expected, userResourcesTest.getFirstName());
	}
	

}

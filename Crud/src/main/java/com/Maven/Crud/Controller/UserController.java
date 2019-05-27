package com.Maven.Crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Maven.Crud.Domain.UserResponse;
import com.Maven.Crud.Service.UserService;

@RestController //Class as Controller where RequestMapping assume ResponseBody semantics.
@Validated 
public class UserController {
		
	@Autowired
	private UserService service;
		
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/users/{id}") //Maps web request with the method
	public UserResponse findUsersbyId(@PathVariable(value = "id", required = true) int id) {
		 return service.getById(id);
				
	}
}

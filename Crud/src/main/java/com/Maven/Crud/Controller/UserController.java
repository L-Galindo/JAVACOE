package com.Maven.Crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Maven.Crud.Domain.UserResponse;
import com.Maven.Crud.Model.UserResources;
import com.Maven.Crud.Service.UserService;

@RestController //Class as Controller where RequestMapping assume ResponseBody semantics.
@Validated 
public class UserController {
				
	@Autowired
	private UserService service;
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/users") //Maps web request with the method
	public List<UserResources> findAllUsers() {
		 return service.getAllUsers();	
	}
		
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/user/{id}") //Maps web request with the method
	public UserResponse findUsersbyId(@PathVariable(value = "id", required = true) int id) {
		 return service.getById(id);	
	}
	
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/user/add/{firstName}/{lastName}/{email}")
//	public UserResponse createUser(@PathVariable (value = "firstName", required = true) String firstName,
//			@PathVariable (value = "lastName", required = true) String lastName,
//			@PathVariable (value = "email", required = true) String email) {
//		UserResources userResources = new UserResources();
//		
//		userResources.setFirstName(firstName);
//		userResources.setLastName(lastName);
//		userResources.setEmail(email);
//		
//		UserResponse userResponse = service.createUser(userResources);
//		
//		return userResponse;		
//	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/user/add")
	@ResponseBody
	public UserResponse createUser(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "email") String email) {
		
		UserResources userResources = new UserResources();
		userResources.setFirstName(firstName);
		userResources.setLastName(lastName);
		userResources.setEmail(email);
		
		UserResponse userResponse = service.createUser(userResources);
		
		return userResponse;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("user/edit")
	@ResponseBody
	public UserResponse editUser(@RequestParam(value = "id") int id,
			@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "email") String email) {
		
		UserResources userResources = new UserResources();
		
		userResources.setId(id);
		userResources.setFirstName(firstName);
		userResources.setLastName(lastName);
		userResources.setEmail(email);
		
		UserResponse userResponse = service.editUser(userResources);
		
		return userResponse;		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("user/delete/{id}") //Maps web request with the method
	public String deleteUser(@PathVariable(value = "id", required = true) int id) {
		 return service.deleteUserFromTable(id);
	}
}

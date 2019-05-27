package com.Maven.Crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maven.Crud.Domain.UserResponse;
import com.Maven.Crud.Model.UserResources;
import com.Maven.Crud.Repository.UserRepository;

@Service //Class as service
public class UserServiceImpl implements UserService {
	
	@Autowired //initializes 
	private UserRepository userRepository;
	
	@Override //Runtime polymorphism.
	public UserResponse getById(int id) {
		UserResponse userResponse = new UserResponse();
		UserResources userResources;
		
		userResources = userRepository.findById(id);
		
		userResponse.setId(userResources.getId());
		userResponse.setFirstName(userResources.getFirstName());
		userResponse.setLastName(userResources.getLastName());
		userResponse.setEmail(userResources.getEmail());
		
		return userResponse;		
	}
}

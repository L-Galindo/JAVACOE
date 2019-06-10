package com.Maven.Crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import com.Maven.Crud.Domain.UserResponse;
import com.Maven.Crud.Exceptions.UserNotFoundException;
import com.Maven.Crud.Model.UserResources;
import com.Maven.Crud.Repository.UserRepository;


@Service //Class as service 
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserResources.class);
					
	@Autowired //initializes 
	private UserRepository userRepository;
	
	private UserResources userResources;
	
	@Override
	public List <UserResources> getAllUsers() {
		List<UserResources> userResources = userRepository.findAll();
		logger.debug("UserResources found {}", userResources);
		if(userResources.toString() == "[]") {
			throw new UserNotFoundException("No users exist in the database");
		}
		return userResources;
	}
				
	@Override
	public UserResponse getById(int id) {
		UserResponse userResponse = new UserResponse();

		userResources = userRepository.findById(id);
		logger.debug("UserResources found {}", userResources);
		if(userResources == null) {
			throw new UserNotFoundException("A user with the ID #" + id + " doesn't exist"); 
		}						
				
		userResponse.setId(userResources.getId());
		userResponse.setFirstName(userResources.getFirstName());
		userResponse.setLastName(userResources.getLastName());
		userResponse.setEmail(userResources.getEmail());
		
		return userResponse;		
	}
	
	@Override
	public UserResponse createUser(UserResources userResources) {
		UserResponse userResponse = new UserResponse();	
		
		UserResources newUserResources = userRepository.save(userResources);
		logger.debug("UserResources found {}", userResources);
		if(newUserResources == null) {
			throw new UserNotFoundException("The user couldn't be created");
		}
		
		userResponse.setId(newUserResources.getId());
		userResponse.setFirstName(newUserResources.getFirstName());
		userResponse.setLastName(newUserResources.getLastName());
		userResponse.setEmail(newUserResources.getEmail());
		
		return userResponse;
	}
	
	@Override
	public UserResponse editUser(UserResources userResources) {
		UserResponse userResponse = new UserResponse();
						
		UserResources validateUserResources = userRepository.findById(userResources.getId());

		logger.debug("UserResources found {}", validateUserResources);
		
		if(validateUserResources == null) {			
			throw new UserNotFoundException("A user with that ID doesn't exist"); 
		}
				
		UserResources newUserResources = userRepository.save(userResources);
		
		userResponse.setId(newUserResources.getId());
		userResponse.setFirstName(newUserResources.getFirstName());
		userResponse.setLastName(newUserResources.getLastName());
		userResponse.setEmail(newUserResources.getEmail());
		
		return userResponse;
	}

	@Override
	public String deleteUserFromTable(int id) {
		try {
			 userRepository.deleteById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("A user with the ID #" + id + " doesn't exist");
		}
		return "User was deleted succesfully";
	}
}

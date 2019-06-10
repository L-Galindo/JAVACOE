package com.Maven.Crud.Service;

import java.util.List;

import com.Maven.Crud.Domain.UserResponse;
import com.Maven.Crud.Model.UserResources;

public interface UserService {
	public List<UserResources> getAllUsers();
	public UserResponse getById(int id);
	public UserResponse createUser(UserResources userResources);
	public UserResponse editUser(UserResources userResources);
	public String deleteUserFromTable(int id);

}

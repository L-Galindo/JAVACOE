package com.Maven.Crud.Repository;

import org.springframework.data.repository.CrudRepository; //Allows CRUD operations
import org.springframework.stereotype.Repository;

import com.Maven.Crud.Model.UserResources;

@Repository //Class as Repository
public interface UserRepository extends CrudRepository<UserResources, String> {
	UserResources findById(int id); 
}

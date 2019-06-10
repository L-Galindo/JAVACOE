package com.Maven.Crud.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Maven.Crud.Model.UserResources;

@Repository //Class as Repository
public interface UserRepository extends JpaRepository<UserResources, Integer> {
	UserResources findById(@Valid @NotBlank int id); 
}

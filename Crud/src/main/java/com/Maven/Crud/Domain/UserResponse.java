package com.Maven.Crud.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class UserResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
}

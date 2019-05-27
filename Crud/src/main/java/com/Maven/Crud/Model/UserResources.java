package com.Maven.Crud.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //POJO. Mapping to the database
@Table(name = "USERS") //The following class attributes compose a table.
public class UserResources {	
	@Id //declares primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generates ID values.
	private int id;

	@NotNull 
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotNull
	@Column(name="LAST_NAME")
	private String lastName;

	@NotNull
	@Column(name = "EMAIL")
	private String email;	
}

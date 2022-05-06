package com.example.pairProgramming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table ( uniqueConstraints = {
		@UniqueConstraint (columnNames = {"username"}),
		@UniqueConstraint (columnNames = {"password"})
		}
)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	private String name;
	private String email;
}

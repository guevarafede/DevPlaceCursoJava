package com.example.pairProgramming.model;

import javax.persistence.Entity;
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
@Table (uniqueConstraints = {
		@UniqueConstraint (columnNames = {"numberPhone"}),
		}
)
public class Student {
	
	@Id
	private long dni;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastname;
	private String numberPhone;

}

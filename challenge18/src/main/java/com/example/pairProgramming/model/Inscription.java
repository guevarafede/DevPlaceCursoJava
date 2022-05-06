package com.example.pairProgramming.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "subject_code")
	private Subject code;
	
	@ManyToOne
	@JoinColumn(name = "student_dni")
	private Student dni;
}

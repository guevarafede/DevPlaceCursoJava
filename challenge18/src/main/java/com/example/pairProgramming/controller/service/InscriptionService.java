package com.example.pairProgramming.controller.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pairProgramming.controller.repositories.InscriptionRepository;
import com.example.pairProgramming.model.Inscription;
import com.example.pairProgramming.model.Student;
import com.example.pairProgramming.model.Subject;

@Service
public class InscriptionService {

	@Autowired
	private InscriptionRepository ir;
	
	public void insertInscription(Student stu, Subject sub) {
		Inscription i = new Inscription();
		i.setDni(stu);
		i.setCode(sub);
		ir.save(i);
	}
}

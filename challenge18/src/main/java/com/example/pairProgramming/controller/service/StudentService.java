package com.example.pairProgramming.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pairProgramming.controller.repositories.StudentRepository;
import com.example.pairProgramming.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sr;
	
	public void insertStudent(Student s) {
		if(!sr.existsById(s.getDni())) {
			sr.save(s);
		}
	}
	
	public void deleteStudent(long dni) {
		if(sr.existsById(dni)) {
			sr.deleteById(dni);
		}
	}
	
	public List<Student> getAll(){
		return sr.findAll();
	}
	
	public Student getStudent(long dni) {
		return sr.getById(dni);
	}
	
	public boolean updateStudent(Student s) {
		if(!sr.existsById(s.getDni())) {
			return false;
		} else {
			sr.save(s);
			return true;			
		}	
	}
}

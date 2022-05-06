package com.example.pairProgramming.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pairProgramming.controller.repositories.SubjectRepository;
import com.example.pairProgramming.model.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository sr;
	
	public void insertSubject(Subject s) {
		if(!sr.existsById(s.getCode())) {
			sr.save(s);
		}
	}
	
	public void deleteSubject(long code) {
		if(sr.existsById(code)) {
			sr.deleteById(code);
		}
	}
	
	public List<Subject> getAll(){
		return sr.findAll();
	}
	
	public Subject getSubject(long code) {
		return sr.getById(code);
	}
	
	public boolean updateSubject(Subject s) {
		if(!sr.existsById(s.getCode())) {
			return false;
		} else {
			sr.save(s);
			return true;			
		}	
	}
}

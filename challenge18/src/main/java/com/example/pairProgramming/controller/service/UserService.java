package com.example.pairProgramming.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pairProgramming.controller.repositories.UserRepository;
import com.example.pairProgramming.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public void insertUser(User u) {
		if(!ur.existsById(u.getId())) {
			ur.save(u);
		}
	}
	
	public void deleteUser(long id) {
		if(ur.existsById(id)) {
			ur.deleteById(id);
		}
	}
	
	public List<User> getAll(){
		return ur.findAll();
	}
	
	public User getUser(long id) {
		return ur.getById(id);
	}
	
	public boolean updateUser(User u) {
		if(!ur.existsById(u.getId())) {
			return false;
		} else {
			ur.save(u);
			return true;			
		}	
	}
	
	
	
	
}

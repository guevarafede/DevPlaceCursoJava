package com.example.pairProgramming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pairProgramming.controller.service.UserService;
import com.example.pairProgramming.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("users", us.getAll());
		return "userIndex";
	}
		
	@GetMapping("/createUser")
	public String showUserForm(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "userCreate";
	}
	
	@PostMapping("/createUser")
	public String insertUser(@ModelAttribute("user") User u) {
		us.insertUser(u);
		return "redirect:/users";
	}
	
	@GetMapping("/update/{id}")
	public String showUser(Model model, @PathVariable("id") long id ) {
		User user = us.getUser(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@ModelAttribute("user") User u, @PathVariable("id") long id) {
		us.updateUser(u);
		return "redirect:/users";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id ){
		us.deleteUser(id);
		return "redirect:/users";
	}
}

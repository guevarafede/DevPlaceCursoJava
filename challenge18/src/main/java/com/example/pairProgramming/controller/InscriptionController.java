package com.example.pairProgramming.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pairProgramming.controller.service.InscriptionService;
import com.example.pairProgramming.controller.service.StudentService;
import com.example.pairProgramming.controller.service.SubjectService;
import com.example.pairProgramming.model.Student;
import com.example.pairProgramming.model.Subject;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {
	
	@Autowired 
	private InscriptionService is;
	
	@Autowired
	private StudentService stus;
	
	@Autowired
	private SubjectService subs;
	
	@GetMapping("/{dni}/{code}")
	public String inscription(@PathVariable("dni") long dni, @PathVariable("code") long code) {
		Student stu = stus.getStudent(dni);
		Subject sub = subs.getSubject(code);
		is.insertInscription(stu, sub);
		return "redirect:/students";
	}
	
	
}

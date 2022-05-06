package com.example.pairProgramming.controller;

import com.example.pairProgramming.controller.service.StudentService;
import com.example.pairProgramming.controller.service.SubjectService;
import com.example.pairProgramming.model.Student;
import com.example.pairProgramming.model.Subject;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService ss;
    
    @Autowired
    private SubjectService subs;
    

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("students", ss.getAll());
        return "Student/studentIndex";
    }

    @GetMapping("/createStudent")
    public String showStudentForm(Model model) {
        Student sub = new Student();
        model.addAttribute("student", sub);
        return "Student/studentCreate";
    }

    @PostMapping("/createStudent")
    public String insertStudent(@ModelAttribute("student") Student sub) {
        ss.insertStudent(sub);
        return "redirect:/students";
    }

    @GetMapping("/update/{dni}")
    public String showStudent(Model model, @PathVariable("dni") long dni ) {
        Student sub = ss.getStudent(dni);
        model.addAttribute("student", sub);
        return "Student/studentUpdate";
    }

    @PostMapping("/update/{dni}")
    public String updateSubject(@ModelAttribute("student") Student sub, @PathVariable("dni") long dni) {
        ss.updateStudent(sub);
        return "redirect:/students";
    }

    @GetMapping("/delete/{dni}")
    public String deleteUser(@PathVariable("dni") long dni ){
        ss.deleteStudent(dni);
        return "redirect:/students";
    }
    
    @GetMapping("/inscription/{dni}")
    public String showInscription(@PathVariable("dni") long dni, Model model) {
    	Student stu = ss.getStudent(dni);
    	ArrayList<Subject> subjects = (ArrayList<Subject>) subs.getAll();
    	model.addAttribute("student", stu);
    	model.addAttribute("subjects", subjects);
    	return "inscriptionSubject";
    }
    

}

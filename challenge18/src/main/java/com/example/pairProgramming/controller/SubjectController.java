package com.example.pairProgramming.controller;

import com.example.pairProgramming.controller.service.SubjectService;
import com.example.pairProgramming.model.Subject;
import com.example.pairProgramming.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService ss;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("subjects", ss.getAll());
        return "Subjects/subjectIndex";
    }

    @GetMapping("/createSubject")
    public String showSubjectForm(Model model) {
        Subject sub = new Subject();
        model.addAttribute("subject", sub);
        return "Subjects/subjectCreate";
    }

    @PostMapping("/createSubject")
    public String insertSubject(@ModelAttribute("subject") Subject sub) {
        ss.insertSubject(sub);
        return "redirect:/subjects";
    }

    @GetMapping("/update/{code}")
    public String showSubject(Model model, @PathVariable("code") long code ) {
        Subject sub = ss.getSubject(code);
        model.addAttribute("subject", sub);
        return "Subjects/subjectUpdate";
    }

    @PostMapping("/update/{code}")
    public String updateSubject(@ModelAttribute("subject") Subject sub, @PathVariable("code") long code) {
        ss.updateSubject(sub);
        return "redirect:/subjects";
    }

    @GetMapping("/delete/{code}")
    public String deleteUser(@PathVariable("code") long code ){
        ss.deleteSubject(code);
        return "redirect:/subjects";
    }
}




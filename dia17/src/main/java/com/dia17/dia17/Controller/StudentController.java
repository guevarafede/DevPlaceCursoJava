package com.dia17.dia17.Controller;

import com.dia17.dia17.Entity.Student;
import com.dia17.dia17.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService stse;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = stse.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneStudent(@PathVariable("id") int id){
        Student student = stse.getOneStudent(id);
        if(student == null) return ResponseEntity.status(400).body("{}");
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping()
    public ResponseEntity<String> saveStudent(@Valid @RequestBody Student student){
        if(!stse.saveStudent(student)) return ResponseEntity.status(400).body("Failed to save a student");
        return ResponseEntity.status(200).body("Saved user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifyStudent(@Valid @RequestBody Student student, @PathVariable("id") int id){
        student.setId(id);
        if(!stse.modifyStudent(student)) return ResponseEntity.status(400).body("Failed to modify an user");
        return ResponseEntity.status(200).body("Modified student");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        if(stse.deleteStudent(id)) return ResponseEntity.status(400).body("Failed to modify an user");
        return ResponseEntity.status(200).body("Deleted student");
    }
}

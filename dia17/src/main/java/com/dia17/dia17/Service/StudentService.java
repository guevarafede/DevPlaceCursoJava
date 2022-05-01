package com.dia17.dia17.Service;

import com.dia17.dia17.Entity.Student;
import com.dia17.dia17.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository sr;

    public List<Student> getAllStudents(){
        return (List<Student>) sr.findAll();
    }

    public boolean saveStudent(Student student) {
        if(sr.existsByDni(student.getDni()) || sr.existsByPhone(student.getPhone())) return false;
        sr.save(student);
        return true;
    }

    public boolean modifyStudent(Student student) {
        if(!sr.existsById(student.getId())) return false;
        sr.save(student);
        return true;
    }

    public boolean deleteStudent(int id) {
        if(!sr.existsById(id)) return false;
        sr.deleteById(id);
        return true;
    }

    public Student getOneStudent(int id) {
        if(!sr.existsById(id)) return null;
        return sr.findById(id).get();
    }


}

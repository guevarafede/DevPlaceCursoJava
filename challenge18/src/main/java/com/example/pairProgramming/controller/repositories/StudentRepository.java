package com.example.pairProgramming.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pairProgramming.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

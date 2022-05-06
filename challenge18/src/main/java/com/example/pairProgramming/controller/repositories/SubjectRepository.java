package com.example.pairProgramming.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pairProgramming.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

}

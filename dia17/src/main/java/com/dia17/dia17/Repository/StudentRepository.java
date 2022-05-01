package com.dia17.dia17.Repository;

import com.dia17.dia17.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public boolean existsByPhone(int phone);
    public boolean existsByDni(int dni);
}

package com.example.demo.Repositories;

import com.example.demo.Entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {


}


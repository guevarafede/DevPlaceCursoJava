package com.dia17.dia17.Repository;

import com.dia17.dia17.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public boolean existsByUsername(String username);

}

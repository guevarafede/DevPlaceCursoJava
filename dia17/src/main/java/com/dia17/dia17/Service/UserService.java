package com.dia17.dia17.Service;

import com.dia17.dia17.Entity.User;
import com.dia17.dia17.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private PasswordEncoder pe;


    public List<User> getAllUses(){
        return (List<User>) ur.findAll();
    }

    public boolean saveUser( User user) {
        if(ur.existsByUsername(user.getUsername())) return false;
        String passwordHashed = pe.encode(user.getPassword());
        user.setPassword(passwordHashed);
        ur.save(user);
        return true;
    }

    public boolean editUser(User user) {
        if(!ur.existsById(user.getId())) return false;
        String passwordHashed = pe.encode(user.getPassword());
        user.setPassword(passwordHashed);
        ur.save(user);
        return true;
    }

    public boolean deleteUser(int id) {
        if(!ur.existsById(id)) return false;
        ur.deleteById(id);
        return true;
    }

    public User getOneUser(int id) {
        if(!ur.existsById(id)) return null;
        return ur.findById(id).get();
    }

}
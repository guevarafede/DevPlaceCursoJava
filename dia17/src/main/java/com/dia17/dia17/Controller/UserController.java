package com.dia17.dia17.Controller;

import com.dia17.dia17.Entity.User;
import com.dia17.dia17.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = us.getAllUses();
        return ResponseEntity.status(200).body(allUsers);
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody User user){
        if(!us.saveUser(user)) return ResponseEntity.status(400).body("Failed to save an user");
        return ResponseEntity.status(201).body("Created user");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user, @PathVariable("id") int id){
        if(!us.editUser(user)) return ResponseEntity.status(400).body("Failed to modify an user");
        user.setId(id);
        return ResponseEntity.status(200).body("Modified user");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        if(!us.deleteUser(id)) return ResponseEntity.status(400).body("Failed to delete an user");
        return ResponseEntity.status(200).body("Deleted user");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id){
        User user = us.getOneUser(id);
        if(user == null) return ResponseEntity.status(200).body("{}");
        return ResponseEntity.status(200).body(user);
    }
}
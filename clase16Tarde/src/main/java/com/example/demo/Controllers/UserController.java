package com.example.demo.Controllers;



import com.example.demo.Entity.UserModel;

import com.example.demo.Repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UserController {

    private UserRepository userRepository;


    @GetMapping
    public List<UserModel> getAllUsers() {
        return this.userRepository.findAll(); //traigo el repositorio y con fidAll obtengo todos los registros.
    }


    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        if( userRepository.existsByDni(user.getDni()) )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El DNI existe"));
        }
        if( userRepository.existsByEmail(user.getEmail()) )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El email existe"));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Usuario Registrado Correctamente"));
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel userModel, @PathVariable ("id") long userId) {
        UserModel addUsers = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found" + userId));
        addUsers.setFirstName(userModel.getFirstName());
        addUsers.setLastName(userModel.getLastName());
        addUsers.setEmail(userModel.getEmail());
        return this.userRepository.save(addUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable ("id") long userId){
        UserModel existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found:" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}

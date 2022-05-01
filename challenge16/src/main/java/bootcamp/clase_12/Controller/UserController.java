package bootcamp.clase_12.Controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import bootcamp.clase_12.Model.User;
import bootcamp.clase_12.Exception.ResourceNotFoundException;

import bootcamp.clase_12.Repository.UserRepository;
import bootcamp.clase_12.Menssage.MessageResponse;


@ApiOperation(value = "Listar usuario", notes="Notas....")
public class UserController {
    @Autowired
    UserRepository userRepository;


    @ApiOperation(value = "Listar usuario", notes="Notas....")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok, Listado de usuarios", response=User.class),
            @ApiResponse(code = 500, message = "Error Server"),
            @ApiResponse(code = 400, message = "no encotro datos")
    })
    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @ApiOperation(value = "Buscar usuario por id", notes="Notas....")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable (value = "id") long userId) {
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

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Usuario Registrado Correctamente"));
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
        User addUsers = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found" + userId));
        addUsers.setFirstName(user.getFirstName());
        addUsers.setLastName(user.getLastName());
        addUsers.setEmail(user.getEmail());
        return this.userRepository.save(addUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
        User existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found:" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}

//@Autowired
//Metodo GET =>GetMapping
//Metodo POST =>PostMapping
//Metodo PUT =>PutMapping
//Metodo DELETE =>DeleteMapping
///METODO GET CON PARAMETROS: GetMapping("ruta/{parametro}")
///PARAMETRO EN LA FUNCION: @PathVariable("parametro") //recibimos el parametro
///(@RequestBody Modelo)
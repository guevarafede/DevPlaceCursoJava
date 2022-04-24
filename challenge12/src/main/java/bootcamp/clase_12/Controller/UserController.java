package bootcamp.clase_12.Controller;
import bootcamp.clase_12.Exception.ResourceNotFoundException;
import bootcamp.clase_12.Model.User;

import java.sql.SQLException;
import java.util.List;

import bootcamp.clase_12.Model.User;
import bootcamp.clase_12.Repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apires/users") //dice la direccion en la que se va a activar esta clase
public class UserController {
    @Autowired //para poder usar el repositorio que creamos, lo declaramos como una variable
               //con autowired, no tenemos que instanciarla, spring ya sabe que existe una instancia y cual utilizar
    private UserRepository userRepository;

    @ApiOperation(value = "Listar usuario", notes = "Notas..." )
   /* @ApiResponses(value = {
            @ApiResponses(code = 200, message = "ok, Listado de usuarios"),
            @ApiResponses(code = 500, message = "Error Server"),
            @ApiResponses(code = 400, message = "no encontro datos")
    })*/
    @GetMapping
    public List<User> getAllUsers() {
        return this.userRepository.findAll(); //traigo el repositorio y con fidAll obtengo todos los registros.
    }

    @ApiOperation(value = "Buscar usuario por id", notes = "Notas..." )
    @GetMapping("/{dni}")
    public User getUserById(@PathVariable (value = "dni") Integer userDni) {
        return this.userRepository.findById(userDni)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userDni));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping("/{dni}")
    public User updateUser(@RequestBody User user, @PathVariable ("dni") Integer userDni) {
        User addUsers = this.userRepository.findById(userDni)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found" + userDni));
        addUsers.setNombre(user.getNombre());
        addUsers.setApellido(user.getApellido());
        addUsers.setDireccion(user.getDireccion());
        return this.userRepository.save(addUsers);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer userDni){
        User existingUser = this.userRepository.findById(userDni)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found:" + userDni));
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


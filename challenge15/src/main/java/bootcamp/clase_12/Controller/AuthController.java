package bootcamp.clase_12.Controller;
import javax.validation.Valid;

import bootcamp.clase_12.Menssage.MessageResponse;
import bootcamp.clase_12.Model.User;
import bootcamp.clase_12.Repository.UserRepository;
import bootcamp.clase_12.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/login")
    public  ResponseEntity<?> auth(@Valid @RequestBody LoginRequest loginRequest){
        User user = userRepository.existsByEmail(loginRequest.getEmail());
        if( user == null )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El usuario no existe"));
        }
        String pass = user.getPassword();
        String passCodificada = encoder.encode(loginRequest.getPassword());
        if (encoder.matches(pass,passCodificada)){
            ResponseEntity.ok(new MessageResponse("Usuario ingreasado Correctamente"));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Error: Password incorrecto"));
    }

    @PostMapping("/register")
    public  ResponseEntity<?> register(@Valid @RequestBody User user){
        if( userRepository.existsByDni(user.getDni()) )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El DNI existe"));
        }
        if( userRepository.existsByEmail(user.getEmail()) != null )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El email existe"));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Usuario Registrado Correctamente"));
    }

}

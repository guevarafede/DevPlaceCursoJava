package bootcamp.clase_12.Controller;
import javax.validation.Valid;

import bootcamp.clase_12.Service.JwtUserDetailsService;
import bootcamp.clase_12.Utils.JwtRequest;
import bootcamp.clase_12.Utils.JwtResponse;
import bootcamp.clase_12.Utils.JwtTokenUtil;
import bootcamp.clase_12.Menssage.MessageResponse;
import bootcamp.clase_12.Model.User;
import bootcamp.clase_12.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
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


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}

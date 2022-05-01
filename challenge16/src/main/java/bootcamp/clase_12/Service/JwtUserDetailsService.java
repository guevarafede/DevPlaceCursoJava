package bootcamp.clase_12.Service;

import bootcamp.clase_12.Repository.UserRepository;
import bootcamp.clase_12.Request.LoginRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository Users;

    @Autowired
    PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User users = Users.findByEmail(email);
        if (users == null) {
            throw new UsernameNotFoundException("El email no existe " + email);
        }
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),
                new ArrayList<>());
    }

    public User save(LoginRequest user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return newUser;
    }
}

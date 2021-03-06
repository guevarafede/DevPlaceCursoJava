//package com.pair.security;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.pair.models.Rol;
//import com.pair.models.Usuario;
//import com.pair.repositories.IUsuarioRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	private IUsuarioRepository uRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario usuario = uRepository.findByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
//
//		return new User(usuario.getNombre(), usuario.getPassword(), mapearRoles(usuario.getRoles()));
//	}
//
//	private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles){
//		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
//	}
//
//}

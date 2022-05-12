package com.pair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pair.models.Usuario;
import com.pair.repositories.IUsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private IUsuarioRepository uRepository;
	
	public List<Usuario> findAll(){
		return uRepository.findAll();
	}
	
	public Optional<Usuario> findById(Long id) {
		if(uRepository.existsById(id)) {
			return uRepository.findById(id);
		}
		return null;
	}
	
	public Usuario save(Usuario usuario) {
		return uRepository.save(usuario);
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		if(uRepository.existsById(usuario.getId())) {
			return uRepository.save(usuario);
		}
		return null;
	}
	
	public boolean deleteById(Long id) {
		if(uRepository.existsById(id)) {
			uRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

package com.pair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pair.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsername(String username);
	public Optional<Usuario> existsByUsername(String username);
}

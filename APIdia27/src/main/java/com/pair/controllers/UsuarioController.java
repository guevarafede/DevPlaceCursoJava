package com.pair.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pair.models.Usuario;
import com.pair.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService uService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listar(){
		return ResponseEntity.ok().body(uService.findAll());
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Optional<Usuario>> findOne(@PathVariable Long id){
		return ResponseEntity.ok().body(uService.findById(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
		return ResponseEntity.ok().body(uService.save(usuario));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		return ResponseEntity.ok().body(uService.save(usuario));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if(uService.deleteById(id)) {
			uService.deleteById(id);
			return ResponseEntity.ok().body("Usuario eliminado");
		}
		return ResponseEntity.notFound().build();
	}
	
}

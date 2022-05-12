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

import com.pair.models.Producto;
import com.pair.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService pService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listar(){
		return ResponseEntity.ok().body(pService.findAll());
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Optional<Producto>> findOne(@PathVariable Long id){
		return ResponseEntity.ok().body(pService.findById(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Producto> update(@RequestBody Producto Producto){
		return ResponseEntity.ok().body(pService.save(Producto));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Producto> save(@RequestBody Producto Producto){
		return ResponseEntity.ok().body(pService.save(Producto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if(pService.deleteById(id)) {
			pService.deleteById(id);
			return ResponseEntity.ok().body("Producto eliminado");
		}
		return ResponseEntity.notFound().build();
	}
}

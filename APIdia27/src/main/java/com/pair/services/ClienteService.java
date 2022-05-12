package com.pair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pair.models.Cliente;
import com.pair.repositories.IClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private IClienteRepository cRepository;
	
	public List<Cliente> findAll(){
		return cRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id) {
		if(cRepository.existsById(id)) {
			return cRepository.findById(id);
		}
		return null;
	}
	
	public Cliente save(Cliente Cliente) {
		return cRepository.save(Cliente);
	}
	
	public Cliente updateCliente(Cliente Cliente) {
		if(cRepository.existsById(Cliente.getId())) {
			return cRepository.save(Cliente);
		}
		return null;
	}
	
	public boolean deleteById(Long id) {
		if(cRepository.existsById(id)) {
			cRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

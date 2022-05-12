package com.pair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pair.models.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	
}

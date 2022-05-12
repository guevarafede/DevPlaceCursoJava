package com.pair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pair.models.Producto;
import com.pair.repositories.IProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private IProductoRepository pRepository;
	
	public List<Producto> findAll(){
		return pRepository.findAll();
	}
	
	public Optional<Producto> findById(Long id) {
		if(pRepository.existsById(id)) {
			return pRepository.findById(id);
		}
		return null;
	}
	
	public Producto save(Producto Producto) {
		return pRepository.save(Producto);
	}
	
	public Producto updateProducto(Producto producto) {
		if(pRepository.existsById(producto.getCodigoProducto())) {
			return pRepository.save(producto);
		}
		return null;
	}
	
	public boolean deleteById(Long id) {
		if(pRepository.existsById(id)) {
			pRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

}

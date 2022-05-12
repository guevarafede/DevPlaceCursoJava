package com.pair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pair.models.DetalleVentas;
import com.pair.models.Venta;
import com.pair.repositories.IDetalleRepository;
import com.pair.repositories.IVentaRepository;

@Service
public class VentaService {
	
	@Autowired
	private IVentaRepository vRepository;
	
	@Autowired
	private IDetalleRepository dRepository;
	
	public List<Venta> findAll(){
		return vRepository.findAll();
	}
	
	public Venta save(Venta venta) {
		return vRepository.save(venta);
	}
	
	public Optional<Venta> findById(Long id) {
		return vRepository.findById(id);
	}

	public List<Venta> listarPorCliente(long id){
		return vRepository.listarPorCliente(id);
	}
	
	public List<DetalleVentas> findAllDetalles(){
		return dRepository.findAll();
	}
	
	public List<DetalleVentas> detallePorCliente(long nro_factura){
		return dRepository.detallePorCliente(nro_factura);
	}
	
	public void agregarDetalle(DetalleVentas detalle) {
		dRepository.save(detalle);
	}
	
	
	
}

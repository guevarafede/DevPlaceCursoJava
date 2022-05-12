package com.pair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pair.models.DetalleVentas;

@Repository
public interface IDetalleRepository extends JpaRepository<DetalleVentas,Long> {
	
	@Query(value = "SELECT * from detalle_ventas where detalle_ventas.nro_factura= :nro_factura", nativeQuery = true)
	public List<DetalleVentas> detallePorCliente(@Param("nro_factura") long nro_factura);
	
}

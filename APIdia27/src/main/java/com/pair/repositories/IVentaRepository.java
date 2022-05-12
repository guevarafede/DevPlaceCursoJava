package com.pair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pair.models.Venta;

import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{

    @Query(value = "SELECT * from ventas where ventas.id_cliente= :id ", nativeQuery = true)
    public List<Venta> listarPorCliente(@Param("id") long id);
}

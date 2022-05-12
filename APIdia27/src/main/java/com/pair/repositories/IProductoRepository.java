package com.pair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pair.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{

}

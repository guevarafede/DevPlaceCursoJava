package com.pair.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalleVentas")
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "nro_factura")
    private Venta nroFactura;

    @ManyToOne
    @JoinColumn(name = "id_productos")
    private Producto idProducto;

    private long cantidad;
   
    
    
}

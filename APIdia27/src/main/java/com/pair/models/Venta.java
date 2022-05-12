package com.pair.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nroFactura")
	private Long nroFactura;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente")
	private Cliente idCliente;
	
	public Venta(Cliente cliente) {
		this.idCliente=cliente;
	}
	
	
}

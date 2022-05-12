package com.pair.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.pair.models.DetalleVentas;
import com.pair.models.Venta;
import com.pair.reportes.VentasExcellReport;
import com.pair.reportes.VentasPdfReport;
import com.pair.services.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	
	@Autowired
	private VentaService vService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Venta>> listar(){
		return ResponseEntity.ok().body(vService.findAll());
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Optional<Venta>> unaVenta(@PathVariable Long id){
		return ResponseEntity.ok().body(vService.findById(id));
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Venta> save(@RequestBody Venta venta){
		return ResponseEntity.ok().body(vService.save(venta));
	}

	@GetMapping("/listarCliente/{id}")
	public ResponseEntity<List<Venta>> getVentaByCliente(@PathVariable long id){
		return ResponseEntity.ok().body(vService.listarPorCliente(id));
	}

	@GetMapping("/reporteVentas/pdf")
	public void reporteVentasPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-ListPDF.pdf");
		VentasPdfReport pdf = new VentasPdfReport(vService.findAll(),vService.findAllDetalles());
		pdf.export(response);
	}
	
	@GetMapping("/reporteVentas/excel")
	public void reporteVentasExcell(HttpServletResponse response) throws DocumentException, IOException{
		response.setContentType("application/octet-string");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-Listexcel.xlsx");
		VentasExcellReport exc = new VentasExcellReport(vService.findAll(),vService.findAllDetalles());
		exc.export(response);
	}
	
	
	@GetMapping("/reporteVentasPorCliente/pdf/{id}")
	public void reporteVentasPDFPorCliente(HttpServletResponse response, @PathVariable("id") long id) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-ListPDF.pdf");
		VentasPdfReport pdf = new VentasPdfReport(vService.listarPorCliente(id),vService.detallePorCliente(id));
		pdf.export(response);
	}
	
	@GetMapping("/reporteVentasPorCliente/excel/{id}")
	public void reporteVentasExcell(HttpServletResponse response,@PathVariable("id") long id) throws DocumentException, IOException{
		response.setContentType("application/octet-string");
		response.setHeader("Content-Disposition","attachment;filename=Ventas-Listexcel.xlsx");
		VentasExcellReport exc = new VentasExcellReport(vService.listarPorCliente(id),vService.detallePorCliente(id));
		exc.export(response);
	}
	
	@PostMapping("/detalle")
	public void agregarDetalle(@RequestBody DetalleVentas detalle) {
		vService.agregarDetalle(detalle);
	}
	
	@GetMapping("/muestraDetalles")
	public ResponseEntity<List<DetalleVentas>> muestraDetalles(){
		return ResponseEntity.ok(vService.findAllDetalles());
	}
	
	
}

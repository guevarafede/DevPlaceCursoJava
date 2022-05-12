package com.pair.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pair.models.DetalleVentas;
import com.pair.models.Venta;


public class VentasPdfReport {
	private List<DetalleVentas> detalles;
    private List<Venta> ventasList;
    
    public VentasPdfReport(List<Venta> ventastList, List<DetalleVentas> detalles)
    {
    	this.detalles = detalles;
        this.ventasList = ventastList;
    }

    public void HeaderTable(PdfPTable table)
    {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.cyan);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("Id Cliente"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Nombre"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Producto"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Cantidad"));
        table.addCell(cell);

    }
    public void BodyTable(PdfPTable table)
    {
        for(Venta venta: ventasList)
        {
        	for(DetalleVentas detalle: detalles) {
        		if(detalle.getNroFactura().getNroFactura() == venta.getNroFactura()) {
        			table.addCell(String.valueOf(venta.getIdCliente().getId()));
        			table.addCell(venta.getIdCliente().getNombre());
        			table.addCell(detalle.getIdProducto().getNombre());
        			table.addCell(String.valueOf(detalle.getCantidad()));        			
        		}
        	}
        }
    }
    public void export(HttpServletResponse hsr) throws DocumentException, IOException
    {
        Document doc = new Document(PageSize.A4);
        PdfWriter.getInstance(doc, hsr.getOutputStream());
        doc.open();
        Paragraph paragraph = new Paragraph("Ventas List");
        paragraph.setSpacingAfter(5);
        paragraph.setAlignment(paragraph.ALIGN_CENTER);
        doc.add(paragraph);
        PdfPTable pdf = new PdfPTable(4);
        HeaderTable(pdf);
        BodyTable(pdf);
        doc.add(pdf);
        doc.close();
    }

}

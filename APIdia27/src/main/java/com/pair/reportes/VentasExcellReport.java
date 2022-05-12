package com.pair.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pair.models.DetalleVentas;
import com.pair.models.Venta;


public class VentasExcellReport {

    private XSSFSheet sheet;
    private XSSFWorkbook wb;
    private List<Venta> ventas;
    private List<DetalleVentas> detalles;

    public VentasExcellReport(List<Venta> ventas, List<DetalleVentas> detalles)
    {
        this.ventas = ventas;
        this.detalles = detalles;
        wb =  new XSSFWorkbook();
    }
    public void readHeader()
    {
        sheet = wb.createSheet("Student-List");
        Row row = sheet.createRow(0);
        CellStyle cS = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeight(16);
        font.setBold(true);
        cS.setFont(font);
        createCell(row, 0,"Id Cliente", cS);
        createCell(row, 1,"Nombre", cS);
        createCell(row, 2,"Producto", cS);
        createCell(row, 3,"Cantidad", cS);
    }
    private void createCell(Row row, int pos, Object name, CellStyle cS){

        
        Cell cell = (Cell)row.createCell(pos);

        if(name instanceof Integer)
        {
            cell.setCellValue((Integer)name);
        }
        else if(name instanceof Boolean)
        {
            cell.setCellValue((Boolean)name);
        }
        else if(name instanceof Long)
        {
            cell.setCellValue((Long)name);
        }
        else
        {
            cell.setCellValue((String)name);
        }

        cell.setCellStyle(cS);


    }
    private void readBody()
    {
        int rC = 1;
        CellStyle cS = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontHeight(12);
        font.setBold(false);
        cS.setFont(font);
        for(Venta venta: ventas)
        {
        	for(DetalleVentas detalle: detalles) {
        		if(detalle.getNroFactura().getNroFactura() == venta.getNroFactura()) {
        			Row row = sheet.createRow(rC);
        			int cC = 0;
        			rC++;
        			createCell(row, cC++,venta.getIdCliente().getId(), cS);
        			createCell(row, cC++,venta.getIdCliente().getNombre(), cS);
        			createCell(row, cC++,detalle.getIdProducto().getNombre(), cS);
        			createCell(row, cC++,detalle.getIdProducto().getNombre(), cS);        			
        		}
        	}
        }
    }
    
    public void export(HttpServletResponse res) throws IOException
    {
        readHeader();
        readBody();
        for(int i=0;i<4;i++) {
        	sheet.autoSizeColumn(i);
        }
        ServletOutputStream stream = res.getOutputStream();
        wb.write(stream);
    }

	
    
}

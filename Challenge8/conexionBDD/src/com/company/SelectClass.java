package com.company;

import java.sql.Date;
import java.sql.*;

public class SelectClass {

    public SelectClass() throws SQLException {

        Conexion dbc=new Conexion();
        if(dbc.getConnection() !=null) {
            try {
                String query = "SELECT * FROM Cliente";
                Statement st = dbc.getConnection().createStatement();//Creo el objeto para ejecutar la sentencia SQL.
                                                                     //Statement sirve para ejecutar consultas.
                ResultSet rs = st.executeQuery(query); //Ejecuta la consulta query, y el resultado se almacena
                                                       //en el ResultSet (conjunto de resultados).
                while (rs.next()) { //mientras alla un resultado siguiente...
                    int id = rs.getInt("idCliente");
                    String nombre = rs.getString("nombreCliente");
                    String apellido = rs.getString("apellidoCliente");
                    String direccion = rs.getString("direccionCliente");
                    Date fechaNac = rs.getDate("fechaNacCliente");
                    System.out.format("%d\n, %s\n, %s\n, %s\n, %s\n", id, nombre, apellido, direccion, fechaNac);
                }
            } catch (Exception e){
                System.out.println("ERROR AL SELECCIONAR.\n"
                        + e.getMessage().toString());
            }
        }
    }
}

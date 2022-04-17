package com.company;
import java.sql.*;

public class UpdateClass {

    public UpdateClass() throws SQLException {

        Conexion dbc=new Conexion();
        if(dbc.getConnection() !=null) {
            try {
                String query="UPDATE cliente SET nombreCliente=?, apellidoCliente=?, direccionCliente=?, fechaNacCliente=? where idCliente=?";
                PreparedStatement st=dbc.getConnection().prepareStatement(query);
                st.setString(1,"Facundo");
                st.setString(2,"Guevara");
                st.setString(3, "Alberti 4525");
                st.setString(4, "1985-04-29");
                st.setInt(5,4);
                st.executeUpdate();
            }
            catch (Exception e) {
                System.out.println("ERROR AL ACTUALIZAR.\n"
                        + e.getMessage().toString());
            }
        }
   }
}

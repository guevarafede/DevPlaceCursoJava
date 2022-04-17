package com.company;

import java.sql.*;
public class InsertClass {

    public boolean insertado=false;
    public InsertClass() throws SQLException {
        Conexion dbc=new Conexion();

        if(dbc.getConnection() !=null) {
            try {
                String query="INSERT INTO cliente (idCliente, nombreCliente, apellidoCliente, direccionCliente, fechaNacCliente) values(?,?,?,?,?)";
                PreparedStatement st=dbc.getConnection().prepareStatement(query);
                st.setInt(1, 0);
                st.setString(2, "Carlos");
                st.setString(3, "Bianchi");
                st.setString(4, "Luro 3443");
                st.setString(5, "1949-05-08");
                st.executeUpdate();
                this.insertado=true;
            }
            catch (Exception e) {
                System.out.println("ERROR AL INSERTAR.\n"
                        + e.getMessage().toString());
            }

        }

    }
    public boolean getInsertado() {
        return this.insertado;
    }

}

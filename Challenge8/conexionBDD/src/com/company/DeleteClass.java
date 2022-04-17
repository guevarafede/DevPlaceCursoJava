package com.company;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteClass {
    public boolean insertado=false;
    public DeleteClass() throws SQLException {

        Conexion dbc=new Conexion();
        if(dbc.getConnection() !=null) {
            try {
                String query="Delete from cliente where idCliente=?";
                PreparedStatement st=dbc.getConnection().prepareStatement(query);
                st.setInt(1,7);
                st.executeUpdate();
            }
            catch (Exception e) {
                System.out.println("ERROR AL BORRAR.\n"
                        + e.getMessage().toString());
            }
        }
    }
}

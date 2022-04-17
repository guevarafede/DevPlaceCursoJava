package com.company;
import java.sql.*;

public class Conexion {
    //Creamos el objeto conexion (vemos el constructor Conexion)
    Connection conectar = null;

    //jdbc (conexion), mysql (tipo de driver), localhost (maquina que voy a conectarme:el puerto), nombre BBDD.
    //NOTA: si uso worckbench el puerto es el 3306, si uso XAMPP el puerto es 33065
    private static final String urlServer = "jdbc:mysql://localhost:3306/challenge8";
    private static final String userDb = "root";
    private static final String passDb = "12345678";

    //Constructor Conexion
    public Conexion() {
        try { //le asignamos al objeto conexion (seria el conectar) el driver con los datos de la conexion)
            this.conectar = DriverManager.getConnection(urlServer, userDb, passDb);
            System.out.println("Conexion exitosa");
        }
        catch(SQLException e){
            System.out.println("Error en conexion");
        }
    }

    //este metodo nos retorna la conexion
    public Connection getConnection() {
        return this.conectar;
    }

    //creo que es para desconectar la base.
    public void close() {
        if (this.conectar != null) {
            try {
                this.conectar.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

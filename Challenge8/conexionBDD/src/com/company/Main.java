package com.company;

import java.sql.*;  ///aca estaria importando
                        //import java.sql.Connection;
                        //import java.sql.DriverManager;
                        //import java.sql.ResultSet;
                        //import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner reader = new Scanner(System.in);
        char entrada;
        do {
            System.out.println("\n********** MENU DE OPCIONES *********\n");
            System.out.println("----- 1- Insert Cliente");
            System.out.println("----- 2- Update Cliente");
            System.out.println("----- 3- Delete Cliente");
            System.out.println("----- 4- Select Cliente");
            int opcion = reader.nextInt();
            switch (opcion) {
                case 1: {
                    InsertClass clienteinsert = new InsertClass();
                    if (clienteinsert.getInsertado()) {
                        System.out.println("Registro Insertado");
                    } else {
                        System.out.println("Registro No Insertado");
                    }
                    break;
                }
                case 2: {
                    UpdateClass clienteUpdate = new UpdateClass();
                    break;
                }
                case 3: {
                    DeleteClass clienteDelete = new DeleteClass();
                    break;
                }
                case 4: {
                    SelectClass clienteSelect = new SelectClass();
                    break;
                }
            }
            System.out.println("DESEA CONTINUAR? S/N");
            entrada = reader.next().charAt(0);
        }while(entrada == 's' || entrada == 'S');
    }
}

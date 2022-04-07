package com.utn.Dia4Tarde;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ingrese 3 valores");
        Scanner teclado = new Scanner(System.in);
        var val1 = teclado.nextDouble();
        var val2 = teclado.nextDouble();
        var val3 = teclado.nextDouble();
        var discriminante = (val2 * val2) - (4 * val1 * val3);
        var sumaTresPotencia = (val1 * val1) + (val2 * val2) + (val3 * val3);
        var sumaDosPotencia = (val1 * val1) + (val2 * val2);
        int op;
        do {
            System.out.println("1- Modulo vector posicion de cordenadas con 3 condiciones");
            System.out.println("2- Modulo vector posicion de coordenadas con 2 condiciones");
            System.out.println("3- Velocidad Media");
            System.out.println("4- Baskarha");
            System.out.println("5- Derivacion");
            System.out.println("0- Salir");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    var totalPotencia3 = Math.sqrt(sumaTresPotencia);
                    System.out.println(totalPotencia3);
                    break;
                case 2:
                    var totalPotencia2 = Math.sqrt(sumaDosPotencia);
                    System.out.println(totalPotencia2);
                    break;
                case 3:
                    var velMedia = val1 + (val2 * val3);
                    System.out.println(velMedia);
                    break;

                case 4:
                    var total1 = (-val2 + Math.sqrt(discriminante)) / (val1 * 2);
                    var total2 = (-val2 - Math.sqrt(discriminante)) / (val1 * 2);
                    System.out.println(total1);
                    System.out.println(total2);
                    break;
                case 5:
                    System.out.println((int) val1 + "x2 " + (int) val2 + "x " + (int) val3);
                    var x = val1 * 2;
                    System.out.println((int) x + "x " + (int) val2);
                    break;
            }
        } while (op != 0);
    }
}

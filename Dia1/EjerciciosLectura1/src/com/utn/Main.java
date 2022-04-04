package com.utn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Triangulo triangulo1 = new Triangulo(5, 5, 5);
        switch (triangulo1.tipoTraingulo()) {
            case 1: {
                System.out.println("EQUILATERO");
                break;
            }
            case 2: {
                System.out.println("ESCALENO");
                break;
            }
            case 3: {
                System.out.println("ISOCELES");
                break;
            }
        }

        numeroPrimoConIfElse();
        numeroPrimoConSwitch();

        ejercicioCreado1();
        ejercicioCreado2();

    }

    //DETERMINAR SI EL NUMERO INGRESADO ES PRIMO O NO, USANDO IF-ELSE
    public static void numeroPrimoConIfElse() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese un numero entero del 1 al 14: ");
        int entrada = reader.nextInt();
        if (entrada == 0 || entrada == 1 || entrada == 4) { //Estos tres numeros no son primos.
            System.out.println("NO ES PRIMO");
        } else {
            System.out.println("ES PRIMO");
        }
    }

    //DETERMINAR SI EL NUMERO INGRESADO ES PRIMO O NO, USANDO SWITCH
    public static void numeroPrimoConSwitch(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese un numero entero del 1 al 14: ");
        int entrada = reader.nextInt();
        switch (entrada) {
            case 0: {
                System.out.println("NO ES PRIMO");
                break;
            }
            case 1: {
                System.out.println("NO ES PRIMO");
                break;
            }
            case 4: {
                System.out.println("NO ES PRIMO");
                break;
            }
            default:
                System.out.println("ES PRIMO");
        }
    }

    /**SOLICITAR @ NUMEROS ENTEROS Y DETERMINAR EL TIPO DE CUADRILATERO. INDICAR SI ES UN CUADRADO O UN RECTANGULO.
     */
    public static void ejercicioCreado1(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese la Base: ");
        int base = reader.nextInt();
        System.out.println("Ingrese la Altura: ");

        int altura = reader.nextInt();
        if (base == altura) {
            System.out.println("ES UN CUADRADO");
        } else {
            System.out.println("ES UN RECTANGULO");
        }
    }


}


package com.utn;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        ejercicio3();
    }


    /**Realizar un programa que simule una calculadora, donde realice las operaciones básicas (suma, resta, multiplicación,
     *  división), el usuario debe primero ingresar dos valores, y especificar con un carácter la operación a realizar,
     *  para el uso del ejercicio debe usar la sentencia switch.
     * */
    public static void ejercicio1(){
        Scanner reader = new Scanner(System.in);
        double resultado;
        char entrada;
        do {
            resultado = 0;
            System.out.println("Ingrese valor 1:");
            double valor1 = reader.nextDouble();
            System.out.println("Ingrese la operacion que desea realizar: \n+ \n- \n* \n/");
            entrada = reader.next().charAt(0);
            System.out.println("Ingrese valor 2:");
            double valor2 = reader.nextDouble();
            switch (entrada) {
                case '+': {
                    resultado = valor1 + valor2;
                    System.out.println("RESULTADO = " + resultado);
                    break;
                }
                case '-': {
                    resultado = valor1 - valor2;
                    System.out.println("RESULTADO = " + resultado);
                    break;
                }
                case '*': {
                    resultado = valor1 * valor2;
                    System.out.println("RESULTADO = " + resultado);
                    break;
                }
                case '/': {
                    if (valor2 != 0) {
                        resultado = valor1 / valor2;
                        System.out.println("RESULTADO = " + resultado);
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                }
            }
            System.out.println("\nDesea realizar otra operacion? S/N");
            entrada = reader.next().charAt(0);
        }while (entrada == 's' || entrada == 'S');
    }

    /** Realizar un programa que visualice por pantalla todos los caracteres correspondientes a letras minúsculas.*/
    public static void ejercicio2(){
        Scanner reader = new Scanner(System.in);
        System.out.println("INGRESE PALABRA:");
        String palabra = reader.next();
        char[] caracteres = new char[10];
        caracteres = palabra.toCharArray();
        for (int i=0; i<caracteres.length; i++){
            int valorAscii = (int) caracteres[i];
            if (valorAscii >= 97 && valorAscii <=122){
                System.out.println(caracteres[i]);
            }
        }
    }

    /** Realizar un programa que permita ingresar por teclado 10 números en un arreglo y debe:
     *  Mostrar el número mayor
     *  Mostrar el número menor
     *  Mostrar los números pares
     *  Mostrar los números impares
     *  Ordenarlos de manera Ascendente
     *  Ordenarlos de manera Descendente
     *  */

    public static void ejercicio3(){
        Scanner reader = new Scanner(System.in);
        int[] numeros = new int[10];
        ArrayList pares = new ArrayList();
        ArrayList impares = new ArrayList();
        int mayor =0;
        int menor =100000;
        for (int i=0; i<numeros.length; i++){
            System.out.println("Ingrese numero " + (i+1)+ ":" );
            numeros[i] = reader.nextInt();
            if (numeros[i] % 2 == 0 ){
                pares.add(numeros[i]);
            }else{
                impares.add(numeros[i]);
            }
        }
        for (int i=0; i<numeros.length; i++){
            if (numeros[i] >= mayor){
                mayor = numeros[i];
            };
            if (numeros[i] <= menor){
                menor = numeros[i];
            };

        }
        System.out.println("EL MAYOR NUMERO DEL ARREGLO ES: " + mayor);
        System.out.println("EL MENOR NUMERO DEL ARREGLO ES: " + menor);
        System.out.println("LOS NUMEROS PARES DEL ARREGLO SON: ");
        for (int i=0; i<pares.size(); i++){
            System.out.println("\n"+pares.get(i));
        }
        System.out.println("LOS NUMEROS IMPARES DEL ARREGLO SON: ");
        for (int i=0; i<impares.size(); i++){
            System.out.println("\n"+impares.get(i));
        }
        Arrays.sort(numeros);
        System.out.println("ARREGLO ORDENADO EN FORMA ASCENDENTE:");
        for (int i=0; i<numeros.length; i++){
            System.out.println(numeros[i]);
        }

        System.out.println("ARREGLO ORDENADO EN FORMA DESCENDENTE:");
        for (int i=0; i<numeros.length; i++){
            for (int j=0; j<numeros.length; j++){
                if (numeros[i] > numeros[j]){
                    int aux = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }
        for (int i=0; i<numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}

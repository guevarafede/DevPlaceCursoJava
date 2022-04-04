package com.utn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // ejercicio1();
       // ejercicio2();
       // ejercicio3();
       // ejercicio4();
       // ejercicio5();
        ejercicio6();
    }

    public static void ejercicio1() {
        float imc; //Indice de Masa Corporal = Peso / (Altura^2)

        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese su peso: ");
        float peso = reader.nextFloat();
        System.out.println("Ingrese su altura: ");
        float altura = reader.nextFloat();
        imc = (float) (peso / Math.pow(altura,2));
        if (imc < 20) {
            System.out.println("MAL ESTADO.");
        } else if (imc >= 20 && imc < 22) {
                System.out.println("BAJO PESO.");
        } else if (imc >= 22 && imc < 25) {
                System.out.println("PESO NORMAL");
        } else if (imc >= 25 && imc < 30) {
                System.out.println("SOBREPESO.");
        } else if (imc >= 30 && imc < 40) {
                System.out.println("SOBREPESO CRONICO.");
        } else {
                System.out.println("HOSPITALIZADO.");
        }
    }

    /**Realizar un programa para el cálculo de las raíces de ecuación de segundo grado, el programa debe diferenciar
     entre las raíces imaginarias, raíces distintas, raíces iguales.
     */

    public static void ejercicio2() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese el termino 'a': ");
        int a = reader.nextInt();
        System.out.println("Ingrese el termino 'b': ");
        int b = reader.nextInt();
        System.out.println("Ingrese el termino 'c': ");
        int c = reader.nextInt();
        double discriminante = Math.pow(b,2) - 4*a*c;
        if (discriminante > 0){
            System.out.println("DOS RAICES REALES DIFERENTES.");
        }else if (discriminante == 0) {
            System.out.println("DOS RAICES REALES IGUALES.");
        }else{
            System.out.println("DOS RAICES COMPLEJAS DIFERENTES.");
        }

    }

    /**Realizar un programa para calcular el promedio de tres notas, e indique si el promedio es menor de 10 que muestre
     reprobado, si es mayor que 10 pero menor que 15 aprobado, y mayor de 15 eximido.
     */
    public static void ejercicio3() {
        float suma=0;
        float promedio;
        Scanner reader = new Scanner(System.in);
        for (int i=0; i<3; i++){
            System.out.println("Ingrese Nota " + (i+1) + ": ");
            float nota = reader.nextFloat();
            suma = suma + nota;
        }
        promedio = suma/3;
        if (promedio < 10) {
            System.out.println("REPROBADOO.");
        } else if (promedio >= 10 && promedio < 15) {
            System.out.println("APROBADO.");
        }else {
            System.out.println("EXIMIDO.");
        }

    }

    /**Realizar un programa que indique el mayor de tres valores numéricos.*/
    public static void ejercicio4() {
        Scanner reader = new Scanner(System.in);
        int mayor = 0;
        for (int i=0; i<3; i++){
            System.out.println("Ingrese valor numerico " + (i+1) + ": ");
            int valorNumerico = reader.nextInt();
            if (valorNumerico > mayor){
                mayor = valorNumerico;
            }
        }
        System.out.println("EL MAYOR VALOR INGRESADO ES: " + mayor);
    }

    /**Realizar un programa que indique el menor de tres valores numéricos. */
    public static void ejercicio5() {
        Scanner reader = new Scanner(System.in);
        int menor = 100000;
        for (int i=0; i<3; i++){
            System.out.println("Ingrese valor numerico " + (i+1) + ": ");
            int valorNumerico = reader.nextInt();
            if (valorNumerico < menor){
                menor = valorNumerico;
            }
        }
        System.out.println("EL MENOR VALOR INGRESADO ES: " + menor);
    }

    /**Crea una aplicación que pida un número por teclado y después comprobaremos si el número introducido es capicúa,
     es decir, que se lee igual sin importar la dirección. Por ejemplo, si introducimos 30303 es capicúa, si introducimos
     30430 no es capicua. Piensa cómo puedes dar la vuelta al número. Una forma de pasar un número a un array es esta
     Character.getNumericValue(cadena.charAt(posicion)).
     */
    public static void ejercicio6() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese numero': ");
        int numero = reader.nextInt();
            System.out.println("¿El número " + numero + " es capicúa?: " + esCapicua(numero));
        }

        public static boolean esCapicua(int numero){
            String palabra = String.valueOf(numero);

            for (int i = 0, j = palabra.length() - 1; i <= j; i++, --j) {
                if (palabra.charAt(i) != palabra.charAt(j)){
                    return false;
                }
            }
            return true;
        }
}



package com.utn.Challenge4;

public class Main {

    public static void main(String[] args) {

        Particular auto = new Particular("EFT698", 3);
        Remolque remolque = new Remolque(10000);
        Carga camion = new Carga("HSS500");

        System.out.println("------- AUTO ------");
        auto.acelerar(120);
        System.out.println(auto);
        System.out.println("\n");

        System.out.println("--- CAMION SIN ACOPLADO ---");
        camion.acelerar(120);
        System.out.println(camion);
        System.out.println("\n");

        System.out.println("-- PONGO ACOPLADO AL CAMION --");
        camion.ponRemolque(remolque);
        camion.acelerar(120);
        System.out.println(camion);
        System.out.println("\n");

        System.out.println("-- QUITO ACOMPLADO AL CAMION --");
        camion.quitaRemolque();
        camion.acelerar(120);
        System.out.println(camion);

    }
}

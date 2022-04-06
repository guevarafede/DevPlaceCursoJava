package com.utn.EmpresaConstructora;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Alberti 4652", 100, "Imperio", 6);
        Comercio comercio = new Comercio("Italia 3324", 58,  "Toledo", "Almacen");
        Domestica casa = new Domestica("Independencia 2244", 32, 2);

        System.out.println("EL COSTO PARA CONSTRUIR EL HOTEL ES: " + hotel.precioDeObra(hotel.getCantMetrosConstruidos(),hotel.getPRECIO_METRO_CONSTRUIDO()));

    }
}

package com.utn;

public class Cancion {private String nombre;
    private float duracion;

    public Cancion(String nombre, float d) {
        this.nombre = nombre;
        this.duracion = d;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    @Override
    public String toString() {
        return "-Cancion [nombre=" + nombre + ", duracion=" + duracion + "]-";
    }

}

package com.company;

public class NoDocente extends Empleado {
    private String seccion;

    public NoDocente(String nombre, String apellido, int dni, String estadoCivil, int anioIncorporaciion, int numeroDespacho, String seccion) {
        super(nombre, apellido, dni, estadoCivil, anioIncorporaciion, numeroDespacho);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "NoDocente{" +
                "seccion='" + seccion + '\'' +
                '}';
    }
}

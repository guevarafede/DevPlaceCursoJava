package com.company;
public abstract class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private String estadoCivil;

    public Persona(String nombre, String apellido, int dni, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
}

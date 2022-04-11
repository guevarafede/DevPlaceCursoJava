package com.company;

public abstract class Empleado extends Persona {
    private int anioIncorporaciion;
    private int numeroDespacho;

    public Empleado(String nombre, String apellido, int dni, String estadoCivil, int anioIncorporaciion, int numeroDespacho) {
        super(nombre, apellido, dni, estadoCivil);
        this.anioIncorporaciion = anioIncorporaciion;
        this.numeroDespacho = numeroDespacho;
    }

    public int getAnioIncorporaciion() {
        return anioIncorporaciion;
    }

    public void setAnioIncorporaciion(int anioIncorporaciion) {
        this.anioIncorporaciion = anioIncorporaciion;
    }

    public int getNumeroDespacho() {
        return numeroDespacho;
    }

    public void setNumeroDespacho(int numeroDespacho) {
        this.numeroDespacho = numeroDespacho;
    }

    @Override
    public String toString() {
        return "com.company.Empleado{" +
                "anioIncorporaciion=" + anioIncorporaciion +
                ", numeroDespacho=" + numeroDespacho +
                '}';
    }
}

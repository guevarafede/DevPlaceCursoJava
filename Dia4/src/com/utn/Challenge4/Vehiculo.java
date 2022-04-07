package com.utn.Challenge4;

public abstract class Vehiculo {
    private String matricula;
    private double velocidad;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {

        String formato = "\n * MATRICULA: %s \n * VELOCIDAD: %.2f";
        return String.format(formato, getMatricula(), getVelocidad());

    }
}

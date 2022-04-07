package com.utn.Challenge4;

public class Particular extends Vehiculo implements IMovimiento {

    private int numeroPuertas;

    public Particular(String matricula, int numeroPuertas) {
        super(matricula);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void acelerar(double velocidad) {
        setVelocidad(velocidad);
    }

    @Override
    public String toString() {
        String formato = "VEHICULO PARTICULAR:";
        return formato + super.toString();
    }
}

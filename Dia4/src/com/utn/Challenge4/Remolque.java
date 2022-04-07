package com.utn.Challenge4;

public class Remolque {
    private int peso;

    public Remolque(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "\n * REMOLQUE => Peso: " + peso;
    }
}

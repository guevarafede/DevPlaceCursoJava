package com.utn;

public class Animal implements IAccion{

    public Animal() {
    }

    @Override
    public void alimentarse(){
        System.out.println("Soy un animal y puedo comer de todo");
    }
}

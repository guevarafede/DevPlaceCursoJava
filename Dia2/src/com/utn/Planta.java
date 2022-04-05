package com.utn;

public class Planta implements IAccion {

    public Planta() {
    }

    @Override
    public void alimentarse(){
        System.out.println("Soy una planta y me alimento por fotosintesis");
    }
}

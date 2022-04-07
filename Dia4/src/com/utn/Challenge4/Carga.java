package com.utn.Challenge4;

public class Carga extends Vehiculo implements IMovimiento {
    private Remolque remolque;


    public Carga(String matricula) {
        super(matricula);
        this.remolque = null;
    }

    public Remolque getRemolque() {
        return this.remolque;
    }

    public void setRemolque(Remolque remolque) {
        this.remolque = remolque;
    }

    public void ponRemolque(Remolque remolque){
        setRemolque(remolque);
    };

    public void quitaRemolque(){
        this.remolque = null;
    };

    @Override
    public void acelerar(double velocidad) {
        if (getRemolque() != null && velocidad > 100){
            System.out.println("DEMASIADO RAPIDO");
        }else{
            setVelocidad(velocidad);
        }
    }


    @Override
    public String toString() {
        String datos;
        String formato = "VEHICULO DE CARGA:";
        if (getRemolque() == null){
            datos = formato + super.toString();
        }else{
            datos = formato + super.toString() + getRemolque().toString();
        }
        return datos;
    }
}

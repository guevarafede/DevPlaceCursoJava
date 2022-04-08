package com.utn.Dia5;

import com.utn.Dia5.Despacho;
import com.utn.Dia5.Persona;

public class Secretario extends Empleado implements ISalarioJerarquicos {
    private Despacho despacho = null;

    public Secretario(String nombre, String apellido, int dni, String direccion, int telefono, double salario, int antiguedad, Supervisor supervisor, Despacho despacho) {
        super(nombre, apellido, dni, direccion, telefono, salario, antiguedad, supervisor);
        this.despacho = despacho;
    }



    @Override
    public void incrementoSalario() {
        setSalario(getSalario()+getSalario()*0.05);
    }

    @Override
    public String toString() {
        return "Secretario{" +
                "despacho=" + despacho +
                '}';
    }
}

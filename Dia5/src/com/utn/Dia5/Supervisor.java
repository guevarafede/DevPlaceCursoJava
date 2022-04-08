package com.utn.Dia5;

import com.utn.Dia5.Persona;

public class Supervisor extends Empleado implements ISalarioOperario {

    public Supervisor(String nombre, String apellido, int dni, String direccion, int telefono, double salario, int antiguedad, Supervisor supervisor) {
        super(nombre, apellido, dni, direccion, telefono, salario, antiguedad, supervisor);
    }

    @Override
    public void incrementoSalario(double incremento) {
        setSalario(getSalario()+incremento);
    }
}

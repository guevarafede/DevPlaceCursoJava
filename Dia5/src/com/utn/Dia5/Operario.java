package com.utn.Dia5;

public class Operario extends Empleado implements ISalarioOperario {

    public Operario(String nombre, String apellido, int dni, String direccion, int telefono, double salario, int antiguedad, Supervisor supervisor) {
        super(nombre, apellido, dni, direccion, telefono, salario, antiguedad, supervisor);
    }

    @Override
    public void incrementoSalario(double incremento) {
       setSalario(getSalario()+incremento);
    }

    @Override
    public String toString() {
        return "Operario";
    }
}

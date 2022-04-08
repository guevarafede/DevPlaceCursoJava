package com.utn.Dia5;

public abstract class Empleado extends Persona{
    private double salario;
    private int antiguedad;
    private Supervisor supervisor;

    public Empleado(String nombre, String apellido, int dni, String direccion, int telefono, double salario, int antiguedad, Supervisor supervisor) {
        super(nombre, apellido, dni, direccion, telefono);
        this.salario = salario;
        this.antiguedad = antiguedad;
        this.supervisor = supervisor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void cambiarSupervisor(Supervisor supervisor){
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "salario=" + salario +
                ", antiguedad=" + antiguedad +
                '}';
    }
}

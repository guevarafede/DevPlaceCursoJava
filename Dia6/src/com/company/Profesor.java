package com.company;

public class Profesor extends Empleado{
    private String departamento; //java, php, base de datos

    public Profesor(String nombre, String apellido, int dni, String estadoCivil, int anioIncorporaciion, int numeroDespacho, String departamento) {
        super(nombre, apellido, dni, estadoCivil, anioIncorporaciion, numeroDespacho);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "departamento='" + departamento + '\'' +
                '}';
    }
}

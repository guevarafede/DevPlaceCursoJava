package com.company;

public class Estudiante extends Persona {
    private String nombreCurso;

    public Estudiante(String nombre, String apellido, int dni, String estadoCivil, String nombreCurso) {
        super(nombre, apellido, dni, estadoCivil);
        this.nombreCurso = nombreCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public String toString() {
        return "com.company.Estudiante{" +
                "nombreCurso='" + nombreCurso + '\'' +
                '}';
    }
}

package com.utn.Dia5;

import java.util.ArrayList;

public class Vendedor extends Empleado implements ISalarioJerarquicos, IaltaBajaMod {

    private Coche coche;
    private String areaVenta;
    private ArrayList<Cliente> listaClientes;
    private double porcentajeComision;

    public Vendedor(String nombre, String apellido, int dni, String direccion, int telefono, double salario, int antiguedad, Supervisor supervisor, Coche coche, String areaVenta,  double porcentajeComision) {
        super(nombre, apellido, dni, direccion, telefono, salario, antiguedad, supervisor);
        this.coche = coche;
        this.areaVenta = areaVenta;
        this.listaClientes = new ArrayList<Cliente>();
        this.porcentajeComision = porcentajeComision;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public String getAreaVenta() {
        return areaVenta;
    }

    public void setAreaVenta(String areaVenta) {
        this.areaVenta = areaVenta;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public void incrementoSalario() {
        setSalario(getSalario()+getSalario()*0.10);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "coche=" + coche +
                ", areaVenta='" + areaVenta + '\'' +
                ", listaClientes=" + listaClientes +
                ", porcentajeComision=" + porcentajeComision +
                '}';
    }

    @Override
    public void cambiar(Coche coche){
        setCoche(coche);
    }



    public ArrayList<Cliente> eliminarCliente(Cliente cliente) {
        int posicion = listaClientes.indexOf(cliente);
        listaClientes.remove(posicion);
        return listaClientes;
    }

    public ArrayList<Cliente> agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        return listaClientes;
    }


}

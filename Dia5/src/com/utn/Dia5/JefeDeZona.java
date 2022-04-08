package com.utn.Dia5;

import java.util.ArrayList;

public class JefeDeZona extends Empleado implements ISalarioJerarquicos, IaltaBajaMod {
    private Coche coche;
    private ArrayList<Vendedor> listaVendedores;
    private Despacho despacho;
    private Secretario secretario;

    public JefeDeZona(String nombre, String apellido, int dni, String direccion, int telefono, double salario, int antiguedad, Supervisor supervisor, Coche coche, Despacho despacho, Secretario secretario) {
        super(nombre, apellido, dni, direccion, telefono, salario, antiguedad, supervisor);
        this.coche = coche;
        this.listaVendedores = new ArrayList<Vendedor>();
        this.despacho = despacho;
        this.secretario = secretario;
    }

    @Override
    public void incrementoSalario() {
        setSalario(getSalario()+getSalario()*0.20);
    }

    @Override
    void cambiar(Coche coche){
        this.coche = coche;
    }

    @Override
    void cambiar(Secretario secretario){
        this.secretario = secretario;

    }

    @Override
    public ArrayList<Cliente> eliminar(Cliente cliente) {
        int posicion = listaVendedores.indexOf(cliente);
        listaVendedores.remove(posicion);
        return listaVendedores;
    }

    @Override
    public ArrayList<Vendedor> agregar(Vendedor vendedor) {
        listaVendedores.add(vendedor);
        return listaVendedores;
    }

}

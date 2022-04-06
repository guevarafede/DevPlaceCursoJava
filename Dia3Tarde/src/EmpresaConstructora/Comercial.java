package EmpresaConstructora;

public abstract  class Comercial extends Obra{
    private String nombre;

    public Comercial(String direccion, double cantMetrosConstruidos, String nombre) {
        super(direccion, cantMetrosConstruidos);
        this.nombre = nombre;
    }
}

package EmpresaConstructora;

public class Domestica extends Obra implements  IPresupuesto{
    private int cantidadAmbientes;

    public Domestica(String direccion, double cantMetrosConstruidos, int cantidadAmbientes) {
        super(direccion, cantMetrosConstruidos);
        this.cantidadAmbientes = cantidadAmbientes;
    }

    @Override
    public double precioDeObra(double cantMetrosConstruidos, double precioMetroConstruido) {
        return (cantMetrosConstruidos * precioMetroConstruido);
    }
}

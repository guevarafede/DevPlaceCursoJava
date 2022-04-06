package EmpresaConstructora;

public class Comercio extends Comercial implements IPresupuesto{
    private String rubro;

    public Comercio(String direccion, double cantMetrosConstruidos, String nombre, String rubro) {
        super(direccion, cantMetrosConstruidos, nombre);
        this.rubro = rubro;
    }

    @Override
    public double precioDeObra(double cantMetrosConstruidos, double precioMetroConstruido ) {
        return (cantMetrosConstruidos * precioMetroConstruido);
    }
}

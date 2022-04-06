package EmpresaConstructora;

public class Hotel extends Comercial implements IPresupuesto{
    private int cantidadDePisos;

    public Hotel(String direccion, double cantMetrosConstruidos, String nombre, int cantidadDePisos) {
        super(direccion, cantMetrosConstruidos, nombre);
        this.cantidadDePisos = cantidadDePisos;
    }

    @Override
    public double precioDeObra(double cantMetrosConstruidos, double precioMetroConstruido) {
        return (cantMetrosConstruidos*precioMetroConstruido) + (precioMetroConstruido * cantidadDePisos);
    }


}

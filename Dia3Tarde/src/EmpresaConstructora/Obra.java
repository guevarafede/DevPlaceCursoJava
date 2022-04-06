package EmpresaConstructora;

public abstract class Obra {
    private String direccion;
    private double cantMetrosConstruidos;
    private final double PRECIO_METRO_CONSTRUIDO = 97;

    public Obra(String direccion, double cantMetrosConstruidos) {
        this.direccion = direccion;
        this.cantMetrosConstruidos = cantMetrosConstruidos;

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCantMetrosConstruidos() {
        return cantMetrosConstruidos;
    }

    public void setCantMetrosConstruidos(double cantMetrosConstruidos) {
        this.cantMetrosConstruidos = cantMetrosConstruidos;
    }

    public double getPRECIO_METRO_CONSTRUIDO() {
        return PRECIO_METRO_CONSTRUIDO;
    }

}

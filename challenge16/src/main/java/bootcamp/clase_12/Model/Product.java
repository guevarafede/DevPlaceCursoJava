package bootcamp.clase_12.Model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity  //con esto decimos que es un modelo real
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "codigo")})
//con esta etiqueta controlamos el nombre de la tabla de nuestra base de datos. Decimos que se guarde en esa tabla.
public class Product {
    @ApiModelProperty(hidden=true)
    @Id                                    //.IDENTITY podria ser tambien
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ApiModelProperty(position = 1)
    @NotBlank
    @Size(max = 20)
    @Column(name = "product_name")
    private String productName;

    @ApiModelProperty(position = 2)
    @NotBlank
    @Size(max = 20)
    @Column(name = "codigo")
    private int codigo;

    @ApiModelProperty(position = 3)
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "cantidad")
    private int cantidad;

    @ApiModelProperty(position=0)
    @NotBlank
    @Size(max = 11)
    @Column(name = "precio")
    private double precio;

    public Product() {
    }

    public Product(long id, String productName, int codigo, int cantidad, double precio) {
        this.id = id;
        this.productName = productName;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

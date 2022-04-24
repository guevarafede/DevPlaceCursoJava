package bootcamp.clase_12.Model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*; //aqui se encuentran todas las anotaciones de JPA

//NOTA: las etiquetas @Entity, table, id, etc. son las que nos provee Spring Boot y en particular la libreria JPA,
//

@Entity  //con esto decimos que es un modelo real
@Table(name = "users")  //con esta etiqueta controlamos el nombre de la tabla de nuestra base de datos.
public class User {
    @ApiModelProperty(hidden=true)
    @Id  //si bien aca visualimos el atributo como id, esto la bse de datos no o sabe, por eso va esta etiqueta
         //y la base tiene sus propias propiedades en la tabla, por eso puede ser que se usen mas etiquetas
         //Ej. @GeneratedValue (strategy = GenerationType.IDENTITY) ->indica que es un id que se genera automaticamente y que se autoincremente
         //    @Colum(unique = true, nullable = false) ->indica que es un id unico y que no puede ser nulo
    @Column(name = "dni")
    private int dni;

    @ApiModelProperty(position = 0)
    @Column(name = "nombre")
    private String nombre;
    @ApiModelProperty(position = 1)
    @Column(name = "apellido")
    private String apellido;
    @ApiModelProperty(position = 2)
    @Column(name = "direccion")
    private String direccion;

    public User() {
    }

    public User(int dni, String nombre, String apellido, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    @Required
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Required
    public void setDni(int dni){
        this.dni=dni;
    }

    public int getDni() {
        return dni;
    }
}

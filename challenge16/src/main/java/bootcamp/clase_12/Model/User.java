package bootcamp.clase_12.Model;

import io.swagger.annotations.ApiModelProperty;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.*; //aqui se encuentran todas las anotaciones de JPA

//NOTA: las etiquetas @Entity, table, id, etc. son las que nos provee Spring Boot y en particular la libreria JPA,
//

@Entity  //con esto decimos que es un modelo real
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "dni")})
  //con esta etiqueta controlamos el nombre de la tabla de nuestra base de datos.
public class User {
    @ApiModelProperty(hidden=true)
    @Id  //si bien aca visualimos el atributo como id, esto la bse de datos no o sabe, por eso va esta etiqueta
    //y la base tiene sus propias propiedades en la tabla, por eso puede ser que se usen mas etiquetas
    //Ej. @GeneratedValue (strategy = GenerationType.IDENTITY) ->indica que es un id que se genera automaticamente y que se autoincremente
    //    @Colum(unique = true, nullable = false) ->indica que es un id unico y que no puede ser nulo
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ApiModelProperty(position = 1)
    @NotBlank
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;
    @ApiModelProperty(position = 2)
    @NotBlank
    @Size(max = 20)
    @Column(name = "last_name")
    private String lastName;
    @ApiModelProperty(position = 3)
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @ApiModelProperty(position=0)
    @NotBlank
    @Size(max = 11)
    @Column(name = "dni")
    private int dni;

    @NotBlank
    @Size(max = 120)
    private String password;


    public User() {
    }

    public User(String firstName, String lastName, String email, int dni,String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dni= dni;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
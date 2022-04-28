package bootcamp.clase_12.Model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Clients", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dni")})
public class Client {
    @ApiModelProperty(hidden=true)
    @Id
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

    @ApiModelProperty(position=4)
    @NotBlank
    @Size(max = 11)
    @Column(name = "telefono")
    private int telefono;


    public Client() {
    }

    public Client(long id, String firstName, String lastName, String email, int dni, int telefono) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

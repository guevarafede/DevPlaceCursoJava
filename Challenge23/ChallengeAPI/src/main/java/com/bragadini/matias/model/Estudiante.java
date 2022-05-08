package com.bragadini.matias.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "estudiante")
@AllArgsConstructor
@NoArgsConstructor

public class Estudiante {
    @Id
    private long dni;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    private String telefono;

}

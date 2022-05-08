package com.bragadini.matias.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    private long dni;
    private String nombre;
    private String apellido;
    private String telefono;
}

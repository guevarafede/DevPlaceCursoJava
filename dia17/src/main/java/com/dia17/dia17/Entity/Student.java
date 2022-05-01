package com.dia17.dia17.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"dni"}),
                @UniqueConstraint(columnNames = {"phone"})
        }
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private int phone;

    @NotBlank
    private int dni;
}

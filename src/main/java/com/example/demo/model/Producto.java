package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


// clase que funciona como entidad de la base de datos
@Entity
@Data //lombook getters y setters
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;
    private Integer cantidad;

}

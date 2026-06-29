package com.example.modulo1_practica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categoriatbl")
public class Categoria {
    private Long idCategoria;
    private String etiqueta;
}

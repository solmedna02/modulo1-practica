package com.example.modulo1_practica.entity;

import lombok.Data;

@Data
public class Tarea {
    private Long id;
    
    private String nombre;
    
    private String asignatura;

    private Boolean estado;
}

package com.example.modulo1_practica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuariotbl")
public class Usuario {
    private long idUsuario;
    private String nombre;
    private String correo;


}

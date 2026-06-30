package com.example.modulo1_practica.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tareastbl")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private String asignatura;

    private Boolean estado;

    LocalDate createAt;
    LocalDate updateAt;

    @PrePersist
    void setCrearDate(){
        this.createAt= LocalDate.now();
    }

    @PreUpdate
    void setUpdateDate(){
        this.updateAt= LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(
        name = "usuario_id",
        referencedColumnName = "idUsuario"
    )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(
        name = "categoria_id",
        referencedColumnName = "idCategoria"
    )
    private Categoria categoria;

}

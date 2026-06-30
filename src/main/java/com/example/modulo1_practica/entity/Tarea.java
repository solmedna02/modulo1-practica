package com.example.modulo1_practica.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @Column(name = "id_tarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_tarea")
    private String nombre;

    @Column(name = "asignatura_tarea")
    private String asignatura;

    @Column(name = "estado_tarea")
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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(
        name = "usuario_id",
        referencedColumnName = "idUsuario"
    )
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(
        name = "categoria_id",
        referencedColumnName = "idCategoria"
    )
    private Categoria categoria;

}

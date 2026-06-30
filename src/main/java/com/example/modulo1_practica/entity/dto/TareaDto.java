package com.example.modulo1_practica.entity.dto;

import com.example.modulo1_practica.validation.Crear;
import com.example.modulo1_practica.validation.Editar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class TareaDto {
    @Null(message= "El ID debe estar vacio", groups = Crear.class)
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio", groups = {Crear.class, Editar.class})
    private String nombre;
    
    @NotBlank(message = "La asignatura es obligatoria", groups = {Crear.class, Editar.class})
    private String asignatura;

    @NotBlank(message = "Obligatorio asignar si esta completa", groups = {Crear.class, Editar.class})
    private Boolean estado;
}

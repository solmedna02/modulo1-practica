package com.example.modulo1_practica.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class TareaDto {
    @Null(message= "El ID debe estar vacio")
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "La asignatura es obligatoria")
    private String asignatura;

    private Boolean estado;
}

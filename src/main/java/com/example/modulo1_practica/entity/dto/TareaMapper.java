package com.example.modulo1_practica.entity.dto;

import org.mapstruct.Mapper;


import com.example.modulo1_practica.entity.Tarea;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    TareaDto tareaToTareaDto(Tarea tarea);
    Tarea tareaDtoToTarea(TareaDto dto);

}

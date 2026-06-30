package com.example.modulo1_practica.entity.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.modulo1_practica.entity.Tarea;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    TareaDto tareaToTareaDto(Tarea tarea);

    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    Tarea tareaDtoToTarea(TareaDto dto);

}

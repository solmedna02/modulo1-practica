package com.example.modulo1_practica.entity.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.modulo1_practica.entity.Tarea;

@Mapper
public interface TareaMapper {
    TareaMapper mapper= Mappers.getMapper(TareaMapper.class);

    TareaDto tareaToTareaDto(Tarea tarea);

    Tarea tareaDtoToTarea(TareaDto tareaDto);

}

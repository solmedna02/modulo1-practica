package com.example.modulo1_practica.service;

import java.util.List;

import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.dto.TareaDto;

public interface TareaService{
    List<TareaDto> listarTareas();

    Tarea buscarPorId(Long id);

    Tarea guardarTarea(TareaDto dto);
    
    boolean eliminarTarea(Long id);

    Tarea actualizarTarea(Long id, TareaDto dto );

}

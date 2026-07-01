package com.example.modulo1_practica.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.dto.TareaDto;

public interface TareaService{
    List<TareaDto> listarTareas();

    Tarea buscarPorId(Long id);

    Tarea guardarTarea(TareaDto dto);
    
    boolean eliminarTarea(Long id);

    Tarea actualizarTarea(Long id, TareaDto dto );

    //querys

    List<Tarea> buscarPorEstado(Boolean estado);
    List<Tarea> buscarPorNombre(String nombre);
    Tarea buscarPorAsignatura(String asignatura);
    Tarea buscarPorNombreNative(String nombre);
    Page<TareaDto> buscarPorEstadoPaginado(Boolean estado, Pageable pageable);

}

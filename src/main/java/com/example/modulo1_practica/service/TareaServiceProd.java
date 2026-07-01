package com.example.modulo1_practica.service;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.dto.TareaDto;
@Service
@Profile(value = "prod")
public class TareaServiceProd implements TareaService{
    @Override
    public List<TareaDto> listarTareas() {
        return Collections.emptyList();
    }

    @Override
    public Tarea buscarPorId(Long id) {
        return null;
    }

    @Override
    public boolean eliminarTarea(Long id) {
        return true;
    }

    @Override
    public Tarea actualizarTarea(Long id, TareaDto dto) {
        return null;
    }

    @Override
    public Tarea guardarTarea(TareaDto dto) {
        return null;
    }

    //querys
    
    @Override
    public List<Tarea> buscarPorEstado(Boolean estado) {
        return Collections.emptyList();
    }

    @Override
    public List<Tarea> buscarPorNombre(String nombre) {
        return Collections.emptyList();
    }

    @Override
    public Tarea buscarPorAsignatura(String asignatura) {
        return null;
    }

    @Override
    public Tarea buscarPorNombreNative(String nombre) {
        return null;
    }

    @Override
    public Page<TareaDto> buscarPorEstadoPaginado(Boolean estado, Pageable pageable) {
        return Page.empty();
    }


    
}

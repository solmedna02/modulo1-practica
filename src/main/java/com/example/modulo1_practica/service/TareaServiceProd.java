package com.example.modulo1_practica.service;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Profile;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarTarea'");
    }

    @Override
    public Tarea guardarTarea(TareaDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarTarea'");
    }
}

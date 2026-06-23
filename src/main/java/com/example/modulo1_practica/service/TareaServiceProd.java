package com.example.modulo1_practica.service;

import java.util.Collections;
import java.util.List;

import com.example.modulo1_practica.entity.Tarea;

public class TareaServiceProd implements TareaService{
    @Override
    public List<Tarea> listarTareas() {
        return Collections.emptyList();
    }

    @Override
    public Tarea buscarPorId(Long id) {
        return null;
    }

    @Override
    public Tarea guardarTarea(Tarea tarea) {
        return tarea;
    }

    @Override
    public void eliminarTarea(Long id) {
    }
}

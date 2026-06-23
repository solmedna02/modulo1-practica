package com.example.modulo1_practica.service;

import java.util.List;

import com.example.modulo1_practica.entity.Tarea;

public interface TareaService{
    List<Tarea> listarTareas();

    Tarea buscarPorId(Long id);

    Tarea guardarTarea(Tarea tarea);
    
    void eliminarTarea(Long id);


}

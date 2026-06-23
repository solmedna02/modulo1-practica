package com.example.modulo1_practica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.modulo1_practica.entity.Tarea;

@Service
public class TareaServices1 {
    private final List<Tarea> tareas= new ArrayList<>();

    

    public List<Tarea> listarTareas(){
        return tareas;
    }

    public Tarea buscarPorId(Long id){
        return tareas.stream().filter(tarea-> tarea.getId().equals(id)).findFirst().orElse(null);
    }

    public Tarea guardTarea(Tarea tarea){
        tareas.add(tarea);
        return tarea;
    }
}

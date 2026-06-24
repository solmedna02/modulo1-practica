package com.example.modulo1_practica.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.modulo1_practica.entity.Tarea;

import lombok.extern.slf4j.Slf4j;

@Service
@Profile(value = "dev")
@Slf4j
public class TareaServiceDev implements TareaService{
    //private final Map<Long, Tarea> tareas = new HashMap<>();
    HashMap<Long,Tarea> tareas= new HashMap<>();

    private Long contador = 1L;

    @Override
    public List<Tarea> listarTareas() {
        return new ArrayList<>(tareas.values());
    }

    @Override
    public Tarea buscarPorId(Long id) {
        return tareas.get(id);
    }

    @Override
    public Tarea guardarTarea(Tarea tarea) {
        
        tarea.setId(contador++);
        tareas.put(tarea.getId(), tarea);
        return tarea;
    }

    @Override
    public boolean eliminarTarea(Long id) {
        System.out.println(id);
        System.out.println("\n");


       if (tareas.containsKey(id)) {
        tareas.remove(id);
        return true;
       } else{throw new RuntimeException("Tarea no existe");}
       
       
        
    }
  
     /*
      if (!tareas.containsKey(id)) {
        throw new RuntimeException("Tarea no existe");
       }
       tareas.remove(id);
      */

    @Override
    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        Tarea tareaExistente = tareas.get(id);
        if (tareaExistente==null){
            return null;
        }

        tareaExistente.setAsignatura(tareaActualizada.getAsignatura());
        tareaExistente.setNombre(tareaActualizada.getNombre());
        tareaExistente.setEstado(tareaActualizada.getEstado());
        tareas.put(id, tareaExistente);
        return tareaExistente;
    }


}

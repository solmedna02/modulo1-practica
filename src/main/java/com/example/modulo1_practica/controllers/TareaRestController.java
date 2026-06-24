package com.example.modulo1_practica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.dto.TareaDto;
import com.example.modulo1_practica.exception.TareaInvalidaException;
import com.example.modulo1_practica.service.TareaService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/tareas")
@Slf4j
public class TareaRestController {
    private final TareaService tareaService;


    public TareaRestController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> listarTareas() {
        log.info("Entrando al metodo ListarTareas");
        return tareaService.listarTareas();
    }

    @GetMapping("/{id}")
    public Tarea buscarPorId(@PathVariable Long id) {
        log.info("Entrando al metodo buscarPorID");
        Tarea tarea = tareaService.buscarPorId(id);
        if (tarea == null) {
            throw new TareaInvalidaException("Tarea no encontrada con id: " + id);
        }

        return tarea;
    }

    @PostMapping
    public Tarea crearTarea(@Valid @RequestBody TareaDto dto) {
        log.info("Entrando al metodo crearTareas");
        Tarea tarea = new Tarea();
        tarea.setEstado(dto.getEstado());
        tarea.setAsignatura(dto.getAsignatura());
        tarea.setNombre(dto.getNombre());
        
        return tareaService.guardarTarea(tarea);
    }

    @DeleteMapping
    public ResponseEntity<String>eliminarTarea(@PathVariable Long id){
        log.info("Entrando al metodo EliminarTarea");
        tareaService.eliminarTarea(id);
        return ResponseEntity.ok("Estudiante Eliminado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTodo(@PathVariable Long id,@Valid @RequestBody Tarea tarea){
        log.info("Entrando al metodo Actualizar");
        return ResponseEntity.ok(tareaService.actualizarTarea(id, tarea));
    }
}

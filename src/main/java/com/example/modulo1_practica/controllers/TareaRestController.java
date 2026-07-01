package com.example.modulo1_practica.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.dto.TareaDto;
import com.example.modulo1_practica.exception.TareaInvalidaException;
import com.example.modulo1_practica.service.TareaService;
import com.example.modulo1_practica.validation.Crear;
import com.example.modulo1_practica.validation.Editar;

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
    public List<TareaDto> listarTareas() {
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
    public Tarea crearTarea(@Validated(Crear.class) @RequestBody TareaDto dto) {
        log.info("Entrando al metodo crearTarea");
        
        return tareaService.guardarTarea(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarTarea(@Valid @PathVariable Long id){
        tareaService.eliminarTarea(id);
        return ResponseEntity.ok("Tarea Eliminada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTodo(@PathVariable Long id,@Validated(Editar.class) @RequestBody TareaDto tarea){
        log.info("Entrando al metodo Actualizar con ID: {}", id);
        return ResponseEntity.ok(tareaService.actualizarTarea(id, tarea));
    }

    //querys

    @GetMapping("/estado/{estado}")
    public List<Tarea> buscarPorEstado(@PathVariable Boolean estado){
        return tareaService.buscarPorEstado(estado);
    }

    @GetMapping("/buscar")
    public List<Tarea> buscar(@RequestParam String nombre){
        return tareaService.buscarPorNombre(nombre);
    }

    @GetMapping("/asignatura/{asignatura}")
    public Tarea buscarPorAsignatura(@PathVariable String asignatura) {
        return tareaService.buscarPorAsignatura(asignatura);
    }

    @GetMapping("/native/{nombre}")
    public Tarea buscarPorNombreNative(@PathVariable String nombre) {
        return tareaService.buscarPorNombreNative(nombre);
    }

    @GetMapping("/estado-paginado")
    public Page<TareaDto> buscarPorEstadoPaginado(
            @RequestParam Boolean estado,
            Pageable pageable) {
        return tareaService.buscarPorEstadoPaginado(estado, pageable);
    }
}

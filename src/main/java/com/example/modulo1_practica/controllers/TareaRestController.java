package com.example.modulo1_practica.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<TareaDto>> listarTareas() {
        log.info("Entrando al metodo ListarTareas");
        return ResponseEntity.ok(tareaService.listarTareas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        log.info("Entrando al metodo buscarPorID");
        
        Tarea tarea = tareaService.buscarPorId(id);
        if (tarea == null) {
            //throw new TareaInvalidaException("Tarea no encontrada con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarea no encontrada por id:"+ id);
        }else{
            return ResponseEntity.ok(tarea);
        }

        
    }

    @PostMapping
    public ResponseEntity<?> crearTarea(@Validated(Crear.class) @RequestBody TareaDto dto) {
        log.info("Entrando al metodo crearTarea");
        tareaService.guardarTarea(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Tarea ha sido creada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminarTarea(@Valid @PathVariable Long id){
        if (tareaService.eliminarTarea(id)) {
            return ResponseEntity.ok("Tarea fue eliminada");
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existe esa tarea");
        }
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTodo(@PathVariable Long id,@Validated(Editar.class) @RequestBody TareaDto tarea){
        log.info("Entrando al metodo Actualizar con ID: {}", id);
        return ResponseEntity.ok(tareaService.actualizarTarea(id, tarea));
    }

    //querys

    @GetMapping("/estado")
    public List<Tarea> buscarPorEstado(@RequestParam Boolean estado){
        return tareaService.buscarPorEstado(estado);
    }

    @GetMapping("/buscar")
    public List<Tarea> buscar(@RequestParam String nombre){
        return tareaService.buscarPorNombre(nombre);
    }

    @GetMapping("/asignatura")
    public Tarea buscarPorAsignatura(@RequestParam String asignatura) {
        return tareaService.buscarPorAsignatura(asignatura);
    }

    @GetMapping("/native")
    public Tarea buscarPorNombreNative(@RequestParam String nombre) {
        return tareaService.buscarPorNombreNative(nombre);
    }

    @GetMapping("/estado-paginado")
    public Page<TareaDto> buscarPorEstadoPaginado(
            @RequestParam Boolean estado,
            Pageable pageable) {
        return tareaService.buscarPorEstadoPaginado(estado, pageable);
    }
}

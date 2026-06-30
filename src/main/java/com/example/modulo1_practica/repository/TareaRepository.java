package com.example.modulo1_practica.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.modulo1_practica.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{

    List<Tarea> findByEstado(Boolean estado);

    List<Tarea> findByNombreContainingIgnoreCase(String nombre);

    Page<Tarea> findByEstado(Boolean estado, Pageable pageable);

    @Query("SELECT t FROM Tarea t WHERE t.nombre = :nombre")
    Tarea findByName( String nombre);

    @Query("SELECT t FROM Tarea t WHERE t.asignatura = :asignatura")
    Tarea findByAsignatura(String asignatura);

    @Query(
        value = "SELECT * FROM tarea WHERE nombre = :nombre", 
        nativeQuery = true)
    Tarea getTareaByNameNative(String nombre);

}

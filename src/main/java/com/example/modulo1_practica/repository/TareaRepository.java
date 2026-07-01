package com.example.modulo1_practica.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.modulo1_practica.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{

    // JPA
    List<Tarea> findByEstado(Boolean estado);

    List<Tarea> findByNombreContainingIgnoreCase(String nombre);

    Page<Tarea> findByEstado(Boolean estado, Pageable pageable);

    //JPQL
    @Query("SELECT t FROM Tarea t WHERE t.nombre = :nombre")
    Tarea findByName( String nombre);

    @Query("SELECT t FROM Tarea t WHERE t.asignatura = :asignatura")
    Tarea findByAsignatura(String asignatura);

    //NATIVE
    @Query(
        value = "SELECT * FROM tareastbl WHERE nombre_tarea = :nombre", 
        nativeQuery = true)
    Tarea getTareaByNameNative(String nombre);

    /* 
    @Query(
        value = "SELECT COUNT(*) AS total FROM tareastbl ", 
        nativeQuery = true
    )
    Long getTotalTarea();

    @Query(
        value = "SELECT * FROM tareastbl WHERE estado_tarea=1", 
        nativeQuery = true)
    Tarea getTareaCompletada();

    @Query(
        value = "SELECT * FROM tareastbl WHERE estado_tarea=0",
        nativeQuery = true)
    Tarea getTareaPendiente();
    
    */

    
    @Query(
        value = "SELECT " +
                "  usuario_id AS usuario, " +
                "  COUNT(*) AS totalTareas, " +
                "  SUM(CASE WHEN estado_tarea = 1 THEN 1 ELSE 0 END) AS completadas, " +
                "  SUM(CASE WHEN estado_tarea = 0 THEN 1 ELSE 0 END) AS pendientes " +
                "FROM tareastbl " +
                "GROUP BY usuario_id", 
        nativeQuery = true
    )
    List<EstadisticasProjection> getEstadisticasPorUsuario();
    
}

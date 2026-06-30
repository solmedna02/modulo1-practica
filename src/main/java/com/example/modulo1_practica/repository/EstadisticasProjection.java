package com.example.modulo1_practica.repository;

public interface EstadisticasProjection {
    String getUsuario();
    Long getTotalTareas();
    Long getCompletadas();
    Long getPendientes();
}

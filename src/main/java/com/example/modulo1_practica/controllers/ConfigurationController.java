package com.example.modulo1_practica.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/configuracion")
public class ConfigurationController {
    private final String nombre;
    private final Integer ejercicio;

    
    
    public ConfigurationController(String nombre, Integer ejercicio) {
        this.nombre = nombre;
        this.ejercicio = ejercicio;
    }

    @GetMapping
    public String mostrarConfiguracion() {
        return "Nombre: " + nombre + " - Ejercicio: " + ejercicio;
    }
    
    
}

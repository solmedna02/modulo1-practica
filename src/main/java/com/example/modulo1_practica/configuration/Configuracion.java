package com.example.modulo1_practica.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {
    @Bean
    public String nombre(){
        return "Ejercicios-Modulo 1";
    }

    @Bean
    public Integer ejercicio(){
        return 2;
    }


}

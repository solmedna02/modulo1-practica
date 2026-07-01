package com.example.modulo1_practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modulo1_practica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

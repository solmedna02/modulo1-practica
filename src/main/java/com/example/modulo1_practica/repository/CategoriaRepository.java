package com.example.modulo1_practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modulo1_practica.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

package com.example.modulo1_practica.service;

import java.util.List;

import com.example.modulo1_practica.entity.Categoria;


public interface CategoriaService {
    List<Categoria> listarCategorias();
    Categoria buscarPorIdCategoria(Long id);
    Categoria crearCategoria(Categoria categoria);
    boolean eliminCategoria(Long id);
    Categoria actualizCategoria(Long id, Categoria categoria);
}

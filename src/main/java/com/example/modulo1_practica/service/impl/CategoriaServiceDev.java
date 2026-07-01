package com.example.modulo1_practica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.modulo1_practica.entity.Categoria;
import com.example.modulo1_practica.repository.CategoriaRepository;
import com.example.modulo1_practica.service.CategoriaService;

public class CategoriaServiceDev implements CategoriaService{

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    @Override
    public Categoria buscarPorIdCategoria(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public boolean eliminCategoria(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public Categoria actualizCategoria(Long id, Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizCategoria'");
    }

}

package com.example.modulo1_practica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.modulo1_practica.entity.Usuario;
import com.example.modulo1_practica.repository.UsuarioRepository;
import com.example.modulo1_practica.service.UsuarioService;

public class UsuarioServicesDev implements UsuarioService{

    @Autowired
    private UsuarioRepository usuariorepo;

    @Override
    public List<Usuario> listaUsuarios() {
        return usuariorepo.findAll();
    }

    @Override
    public Usuario buscarIdUsuario(Long id) {
        return usuariorepo.findById(id).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuariorepo.save(usuario);
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        if (usuariorepo.existsById(id)) {
            usuariorepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        return usuariorepo.save(usuario);
    }

    

}

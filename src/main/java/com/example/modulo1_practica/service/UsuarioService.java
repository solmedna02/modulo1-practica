package com.example.modulo1_practica.service;

import java.util.List;

import com.example.modulo1_practica.entity.Usuario;

public interface UsuarioService {
    List<Usuario> listaUsuarios();
    Usuario buscarIdUsuario(Long id);
    Usuario crearUsuario(Usuario usuario);
    boolean eliminarUsuario(Long id);
    Usuario actualizarUsuario(Long id, Usuario usuario);
}

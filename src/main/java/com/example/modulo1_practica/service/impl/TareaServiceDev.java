package com.example.modulo1_practica.service.impl;

import java.util.List;
//import java.util.Map;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.modulo1_practica.entity.Categoria;
import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.Usuario;
import com.example.modulo1_practica.entity.dto.TareaDto;
import com.example.modulo1_practica.entity.dto.TareaMapper;
import com.example.modulo1_practica.repository.CategoriaRepository;
import com.example.modulo1_practica.repository.TareaRepository;
import com.example.modulo1_practica.repository.UsuarioRepository;
import com.example.modulo1_practica.service.TareaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Profile(value = "dev")
@Slf4j
public class TareaServiceDev implements TareaService{
    @Autowired
    private TareaRepository repository;

    @Autowired
    private UsuarioRepository usuariorepo;

    @Autowired
    private CategoriaRepository categorepo;

    private final TareaMapper tareaMapper = Mappers.getMapper(TareaMapper.class);

    @Override
    @Transactional(readOnly = true)
    public List<TareaDto> listarTareas() {
    return repository.findAll().stream()
            .map(tareaMapper::tareaToTareaDto)
            .toList();
}

    @Override
    @Transactional(readOnly = true)
    public Tarea buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Tarea guardarTarea(TareaDto dto) {
        Tarea tarea = tareaMapper.tareaDtoToTarea(dto);
        Usuario usuario= usuariorepo.findById(dto.getCategoriaId()).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        Categoria categoria= categorepo.findById(dto.getCategoriaId()).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        
        tarea.setUsuario(usuario);
        tarea.setCategoria(categoria);
        
        return repository.save(tarea);
    }

    @Override
    public boolean eliminarTarea(Long id) {
       if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Tarea actualizarTarea(Long id, TareaDto dto) {
        Tarea tarea = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        Usuario usuario=usuariorepo.findById(dto.getUsuarioId()).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        Categoria categoria = categorepo.findById(dto.getCategoriaId()).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));

        tarea.setNombre(dto.getNombre());
        tarea.setAsignatura(dto.getAsignatura());
        tarea.setEstado(dto.getEstado());
        tarea.setUsuario(usuario);
        tarea.setCategoria(categoria);

        return repository.save(tarea);
    }

    //querys
    public List<Tarea> buscarPorEstado(Boolean estado){
        return repository.findByEstado(estado);
    }

    public List<Tarea> buscarPorNombre(String nombre){
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Tarea buscarPorAsignatura(String asignatura) {
        return repository.findByAsignatura(asignatura);
    }

    @Override
    @Transactional(readOnly = true)
    public Tarea buscarPorNombreNative(String nombre) {
        return repository.getTareaByNameNative(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TareaDto> buscarPorEstadoPaginado(Boolean estado, Pageable pageable) {
        return repository.findByEstado(estado, pageable)
                .map(tareaMapper::tareaToTareaDto);
    }


}

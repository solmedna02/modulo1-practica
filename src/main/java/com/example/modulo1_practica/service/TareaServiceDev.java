package com.example.modulo1_practica.service;

import java.util.List;
//import java.util.Map;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.modulo1_practica.entity.Tarea;
import com.example.modulo1_practica.entity.dto.TareaDto;
import com.example.modulo1_practica.entity.dto.TareaMapper;
import com.example.modulo1_practica.repository.TareaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Profile(value = "dev")
@Slf4j
public class TareaServiceDev implements TareaService{
    @Autowired
    private TareaRepository repository;

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

        tarea.setNombre(dto.getNombre());
        tarea.setAsignatura(dto.getAsignatura());
        tarea.setEstado(dto.getEstado());

        return repository.save(tarea);
    }


}

package com.example.modulo1_practica.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(TareaInvalidaException.class)
    public ResponseEntity<String> handlerTareaInvalidaException(TareaInvalidaException ex, WebRequest webRequest) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> manejar400(Exception ex) {
        return respuesta(HttpStatus.BAD_REQUEST, "Solicitud inválida: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejar500(Exception ex) {
        return respuesta(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
    }

    private ResponseEntity<Map<String, Object>> respuesta(HttpStatus estado, String mensaje) {
        Map<String, Object> body = Map.of(
                "fecha", LocalDateTime.now(),
                "estado", estado.value(),
                "error", estado.getReasonPhrase(),
                "mensaje", mensaje
        );
        return ResponseEntity.status(estado).body(body);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> manejarEntidadNoEncontrada(EntityNotFoundException ex) {
        return respuesta(HttpStatus.NOT_FOUND, "El recurso solicitado no existe: " + ex.getMessage());
    }

    // Captura violaciones de bases de datos (Campos únicos duplicados, llaves foráneas inválidas, etc.)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> manejarViolacionIntegridad(DataIntegrityViolationException ex) {
        return respuesta(HttpStatus.CONFLICT, "Error de integridad de datos. Posible registro duplicado o restricción violada.");
    }

}

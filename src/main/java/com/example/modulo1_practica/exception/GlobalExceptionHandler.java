package com.example.modulo1_practica.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TareaInvalidaException.class)
    public ResponseEntity<String> handlerTareaInvalidaException(TareaInvalidaException ex, WebRequest webResquest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class,MethodArgumentNotValidException.class})
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
}

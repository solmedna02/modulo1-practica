package com.example.modulo1_practica.exception;

public class TareaInvalidaException extends RuntimeException{

    public TareaInvalidaException() {
    }

    public TareaInvalidaException(String message) {
        super(message);
    }

    public TareaInvalidaException(Throwable cause) {
        super(cause);
    }

    public TareaInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
    
    

}

package com.prueba.franquicias.exception;

public class FranquiciaNoEncontradaException extends RuntimeException{
    public FranquiciaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}

package com.ProjetoNeki.Exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
    }
    public NotFoundException(String message) {
        super(message);
    }
}
package it.pi.registro.registro.exception;

public class NotDeletableException extends RuntimeException{
    public NotDeletableException(String message) {
        super(message);
    }
}
package ru.bellintegrator.practice.common.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String message){
        super(message);
    }
}

package ru.bellintegrator.practice.common.exception;

public class FieldIsNotBooleanException extends RuntimeException {
    public FieldIsNotBooleanException(String fieldName){
        super("Field " + fieldName + " must be boolean!");
    }
}

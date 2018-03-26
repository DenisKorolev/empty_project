package ru.bellintegrator.practice.common.exception;

public class FieldIsNotLongException extends RuntimeException {
    public FieldIsNotLongException(String fieldName){
        super("Field " + fieldName + " must be Long!");
    }
}

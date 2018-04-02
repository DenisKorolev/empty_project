package ru.bellintegrator.practice.common.exception;

@Deprecated
public class FieldIsNotLongException extends ValidationException {
    public FieldIsNotLongException(String fieldName){
        super("Field " + fieldName + " must be Long!");
    }
}

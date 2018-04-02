package ru.bellintegrator.practice.common.exception;

@Deprecated
public class FieldIsNotBooleanException extends ValidationException  {
    public FieldIsNotBooleanException(String fieldName){
        super("Field " + fieldName + " must be boolean!");
    }
}

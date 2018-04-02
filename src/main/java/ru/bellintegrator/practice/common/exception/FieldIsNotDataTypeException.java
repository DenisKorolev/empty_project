package ru.bellintegrator.practice.common.exception;

public class FieldIsNotDataTypeException extends ValidationException {
    public FieldIsNotDataTypeException(String fieldName, String dataType){
        super("Field " + fieldName + " must be " + dataType + "!");
    }
}

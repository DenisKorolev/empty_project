package ru.bellintegrator.practice.common.exception;

public class RequiredFieldIsNullException extends ValidationException {
    public RequiredFieldIsNullException(String fieldName){
        super("Required field " + fieldName + " couldn't be empty!");
    }
}

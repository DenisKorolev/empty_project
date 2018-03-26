package ru.bellintegrator.practice.common.exception;

public class RequiredFieldIsNullException extends RuntimeException {
    public RequiredFieldIsNullException(String fieldName){
        super("Required field " + fieldName + " couldn't be empty!");
    }
}

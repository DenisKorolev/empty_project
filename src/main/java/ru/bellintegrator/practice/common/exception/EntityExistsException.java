package ru.bellintegrator.practice.common.exception;

public class EntityExistsException extends ValidationException {
    public EntityExistsException(String entityName, String entityId){
        super(entityName + " with id: " + entityId + " already exist!");
    }

    public EntityExistsException(String entityName, String entityParameterName, String entityParameter){
        super(entityName + " with " + entityParameterName + ": " + entityParameter + " already exist!");
    }
}

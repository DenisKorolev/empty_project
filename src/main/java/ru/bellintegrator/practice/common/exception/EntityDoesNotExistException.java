package ru.bellintegrator.practice.common.exception;

public class EntityDoesNotExistException extends ValidationException {
    public EntityDoesNotExistException(String entityName, String entityId){
        super(entityName + " with id: " + entityId + " does not exist!");
    }

    public EntityDoesNotExistException(String entityName, String entityParameterName, String entityParameter){
        super(entityName + " with " + entityParameterName + ": " + entityParameter + " does not exist!");
    }
}

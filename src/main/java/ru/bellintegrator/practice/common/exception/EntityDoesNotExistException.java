package ru.bellintegrator.practice.common.exception;

public class EntityDoesNotExistException extends RuntimeException {
    public EntityDoesNotExistException(String entityName, String entityId){
        super(entityName + " with id: " + entityId + " does not exist!");
    }
}

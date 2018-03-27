package ru.bellintegrator.practice.common.exception;

public class OrgDoesNotExistException extends RuntimeException {
    public OrgDoesNotExistException(String orgId){
        super("Organization with id: " + orgId + " does not exist!");
    }
}

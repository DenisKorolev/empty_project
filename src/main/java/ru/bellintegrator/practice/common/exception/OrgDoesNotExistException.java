package ru.bellintegrator.practice.common.exception;

@Deprecated
public class OrgDoesNotExistException extends ValidationException {
    public OrgDoesNotExistException(String orgId){
        super("Organization with id: " + orgId + " does not exist!");
    }
}

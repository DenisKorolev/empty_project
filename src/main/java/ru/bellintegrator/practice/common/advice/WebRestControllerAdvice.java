package ru.bellintegrator.practice.common.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.common.exception.*;
import ru.bellintegrator.practice.common.view.ErrorView;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(RequiredFieldIsNullException.class)
    public ErrorView handleRequiredFieldIsNullException(RequiredFieldIsNullException ex){
        ErrorView errorView = new ErrorView(ex.getMessage());
        return errorView;
    }

    @ExceptionHandler(FieldIsNotLongException.class)
    public ErrorView handleFieldIsNotLong(FieldIsNotLongException ex){
        ErrorView errorView = new ErrorView(ex.getMessage());
        return errorView;
    }

    @ExceptionHandler(FieldIsNotBooleanException.class)
    public ErrorView handeFieldIsNotBooleanException(FieldIsNotBooleanException ex){
        ErrorView errorView = new ErrorView(ex.getMessage());
        return errorView;
    }

    @ExceptionHandler(OrgDoesNotExistException.class)
    public ErrorView handleOrgDoesNotExistException(OrgDoesNotExistException ex){
        ErrorView errorView = new ErrorView(ex.getMessage());
        return errorView;
    }

    @ExceptionHandler(EntityDoesNotExistException.class)
    public ErrorView handleEntityDoesNotExistException(EntityDoesNotExistException ex){
        ErrorView errorView = new ErrorView(ex.getMessage());
        return errorView;
    }

    public static boolean isStringBoolean(String str){
        if ((str.equals("true")) || (str.equals("false")))
            return true;
        else return false;
    }

    public static boolean isFieldLong(String field, String fieldName) {

        try {
            Long.parseLong(field);
        }
        catch (NumberFormatException ex){
            throw new FieldIsNotLongException(fieldName);
        }

        return true;
    }

    public static void checkFieldOnNullAndNotLong(String field, String fieldName){

        //Checks if field is not null
        if ((field == null) || (field.isEmpty()))
            throw new RequiredFieldIsNullException(fieldName);
        //Checks if filed is Long
        try {
            Long.parseLong(field);
        }
        catch (NumberFormatException ex){
            throw new FieldIsNotLongException(fieldName);
        }
    }
}

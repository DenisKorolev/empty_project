package ru.bellintegrator.practice.common.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.common.exception.FieldIsNotBooleanException;
import ru.bellintegrator.practice.common.exception.FieldIsNotLongException;
import ru.bellintegrator.practice.common.exception.RequiredFieldIsNullException;
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
}

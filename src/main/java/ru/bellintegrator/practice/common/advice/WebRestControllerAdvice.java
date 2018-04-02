package ru.bellintegrator.practice.common.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.bellintegrator.practice.common.exception.*;
import ru.bellintegrator.practice.common.view.ErrorView;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    public ErrorView handleValidationException(ValidationException ex){
        ErrorView errorView = new ErrorView(ex.getMessage());
        return errorView;
    }
}

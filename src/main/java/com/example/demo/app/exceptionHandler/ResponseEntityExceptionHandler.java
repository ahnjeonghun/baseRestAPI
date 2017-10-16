package com.example.demo.app.exceptionHandler;

import com.example.demo.app.exception.BusinessRuleViolationException;
import com.example.demo.app.exception.FieldValidationException;
import com.example.demo.app.exception.NoResourcesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleNotFoundException(Exception ex) {
        ResponseEntity responseEntity;
        if (ex instanceof BusinessRuleViolationException) {
            responseEntity = new ResponseEntity(createErrorEntity(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof FieldValidationException) {
            responseEntity = new ResponseEntity(createErrorEntity(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NoResourcesException) {
            responseEntity = new ResponseEntity(createErrorEntity(ex.getMessage()), HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity(createErrorEntity(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public ErrorEntity createErrorEntity(String message) {
        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setMessage(message);
        return errorEntity;
    }
}

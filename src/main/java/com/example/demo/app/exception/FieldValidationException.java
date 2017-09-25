package com.example.demo.app.exception;

public class FieldValidationException extends IllegalArgumentException {
    public FieldValidationException(String message) {
        super(message);
    }
}

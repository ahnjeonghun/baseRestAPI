package com.example.demo.app.exception;

public class NoResourcesException extends RuntimeException  {
    public NoResourcesException(String message) {
        super(message);
    }
}

package com.example.stockmanagement.exceptions;

public class PreferenceAlreadyExistsException extends RuntimeException {
    public PreferenceAlreadyExistsException(String message) {
        super(message);
    }
}
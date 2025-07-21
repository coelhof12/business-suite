package com.example.stockmanagement.exceptions;

public class PreferenceNotFoundException extends RuntimeException {
    public PreferenceNotFoundException(String message) {
        super(message);
    }
}
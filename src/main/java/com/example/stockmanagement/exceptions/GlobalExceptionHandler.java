package com.example.stockmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Helper method to create standardized error response
    private Map<String, Object> createErrorResponse(String message, HttpStatus status, String path) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", status.value());
        error.put("error", status.getReasonPhrase());
        error.put("message", message);
        error.put("path", path);
        return error;
    }

    // Handle validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                fieldErrors.put(error.getField(), error.getDefaultMessage()));

        Map<String, Object> response = createErrorResponse("Validation failed", HttpStatus.BAD_REQUEST, "/api/validation");
        response.put("fieldErrors", fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Handle ClientNotFoundException
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleClientNotFoundException(ClientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, "/api/clients"));
    }

    // Handle InventoryItemNotFoundException
    @ExceptionHandler(InventoryItemNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleInventoryItemNotFoundException(InventoryItemNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, "/api/inventory-items"));
    }

    // Handle PreferenceAlreadyExistsException
    @ExceptionHandler(PreferenceAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handlePreferenceAlreadyExistsException(PreferenceAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(createErrorResponse(ex.getMessage(), HttpStatus.CONFLICT, "/api/client-preferences"));
    }

    // Handle PreferenceNotFoundException
    @ExceptionHandler(PreferenceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePreferenceNotFoundException(PreferenceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, "/api/client-preferences"));
    }

    // Handle SupplierNotFoundException
    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleSupplierNotFoundException(SupplierNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, "/api/suppliers"));
    }

    //Handle IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, "/api/suppliers"));
    }
}
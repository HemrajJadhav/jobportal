package com.example.jobportal.controllers;

import com.example.jobportal.dto.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // This is like Express error handling middleware!
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RegistrationResponse> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RegistrationResponse(ex.getMessage(), false, null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RegistrationResponse> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new RegistrationResponse("An unexpected error occurred: " + ex.getMessage(), false, null));
    }
}
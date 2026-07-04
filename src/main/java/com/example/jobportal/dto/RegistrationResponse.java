package com.example.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor  // Creates constructor with all fields
public class RegistrationResponse {
    private String message;
    private boolean success;
    private Long userId;
}
package com.example.jobportal.dto;

import lombok.Data;

@Data  // Auto getters, setters, toString
public class RegistrationRequest {
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
}
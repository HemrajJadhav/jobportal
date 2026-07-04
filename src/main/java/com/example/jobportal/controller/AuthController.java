package com.example.jobportal.controller;

import com.example.jobportal.dto.RegistrationRequest;
import com.example.jobportal.dto.RegistrationResponse;
import com.example.jobportal.mappers.UserMapper;
import com.example.jobportal.models.User;
import com.example.jobportal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")  // Allow React frontend
@RequiredArgsConstructor  // Lombok creates constructor for final fields
public class AuthController {

    private final UserRepository userRepository;  // No @Autowired needed!
    private final UserMapper userMapper;  // Auto-injected by Spring

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {

        // Check if user already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(new RegistrationResponse("Email already registered!", false, null));
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest()
                    .body(new RegistrationResponse("Username already taken!", false, null));
        }

        // Auto map DTO to Entity (like object spread in JS)
        User user = userMapper.toUser(request);

        // Save user
        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegistrationResponse("User registered successfully!", true, savedUser.getId()));
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Auth service is running!");
    }
}
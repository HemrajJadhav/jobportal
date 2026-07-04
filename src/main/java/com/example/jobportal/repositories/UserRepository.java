package com.example.jobportal.repositories;

import com.example.jobportal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods - Spring Data JPA auto-implements these!
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByMobileNumber(String mobileNumber);
}
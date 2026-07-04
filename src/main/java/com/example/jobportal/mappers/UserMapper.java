package com.example.jobportal.mappers;

import com.example.jobportal.dto.RegistrationRequest;
import com.example.jobportal.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")  // Makes it a Spring bean
public interface UserMapper {

    // Auto maps RegistrationRequest to User
    // Maps all fields with same name automatically
    User toUser(RegistrationRequest request);

    // If you need to map back
    RegistrationRequest toRequest(User user);
}
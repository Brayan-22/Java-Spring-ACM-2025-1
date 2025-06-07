package com.acm.advices.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 5, max = 50,message = "Username must be between 5 and 50 characters")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 5, max = 50, message = "Password must be between 5 and 50 characters")
    private String password;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;
}

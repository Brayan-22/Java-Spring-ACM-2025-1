package com.acm.mvc.models;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario {
    private Long id;
    @NotEmpty(message = "El nombre de usuario no puede estar vacío")
    private String username;
    @NotEmpty(message = "La contraseña no puede estar vacia")
    private String password;
}
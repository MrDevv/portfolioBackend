package com.mrdevv.portfolioBackend.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank(message = "El nombre es obligatorio")
        String nombres,
        @NotBlank(message = "El apellido es obligatorio")
        String apellidos,
        @NotBlank(message = "El email es obligatorio")
        String email,
        @NotBlank(message = "La contraseña es obligatoria")
        String password,
        @NotBlank(message = "La confirmación de la contraseña es obligatoria")
        String confirmarPassword
) {
}

package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Datos para registrar un nuevo usuario")
public record RegisterDTO(
        @NotBlank(message = "El nombre es obligatorio")
        @Schema(description = "Nombres del usuario", example = "Miguel", requiredMode = Schema.RequiredMode.REQUIRED)
        String nombres,
        @NotBlank(message = "El apellido es obligatorio")
        @Schema(description = "Apellidos del usuario", example = "Vega", requiredMode = Schema.RequiredMode.REQUIRED)
        String apellidos,
        @NotBlank(message = "El email es obligatorio")
        @Schema(description = "Correo electrónico del usuario", example = "usuario@correo.com", requiredMode = Schema.RequiredMode.REQUIRED)
        String email,
        @NotBlank(message = "La contraseña es obligatoria")
        @Schema(description = "Contraseña del usuario", example = "MiPassword123*", requiredMode = Schema.RequiredMode.REQUIRED)
        String password,
        @NotBlank(message = "La confirmación de la contraseña es obligatoria")
        @Schema(description = "Confirmación de la contraseña. Debe ser igual a 'password'", example = "MiPassword123*", requiredMode = Schema.RequiredMode.REQUIRED)
        String confirmarPassword
) {
}

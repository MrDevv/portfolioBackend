package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Credenciales para iniciar sesión")
public record AuthDTO(
        @Schema(description = "Correo electrónico del usuario", example = "usuario@correo.com", requiredMode = Schema.RequiredMode.REQUIRED)
        String email,
        @Schema(description = "Contraseña del usuario", example = "MiPassword123*", requiredMode = Schema.RequiredMode.REQUIRED)
        String password
) {
}

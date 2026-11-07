package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para restablecer la contraseña")
public record ResetPasswordDTO(
        @Schema(description = "Token de recuperación recibido por correo electrónico", example = "c1b2a3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d-6112026", requiredMode = Schema.RequiredMode.REQUIRED)
        String token,
        @Schema(description = "Nueva contraseña", example = "NuevoPassword123*", requiredMode = Schema.RequiredMode.REQUIRED)
        String password
) {
}

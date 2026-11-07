package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para solicitar la recuperación de contraseña")
public record RecoverPasswordDTO(
        @Schema(description = "Correo electrónico de la cuenta", example = "usuario@correo.com", requiredMode = Schema.RequiredMode.REQUIRED)
        String email
) {
}

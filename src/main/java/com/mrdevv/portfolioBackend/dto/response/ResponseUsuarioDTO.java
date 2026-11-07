package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos de un usuario para administración")
public record ResponseUsuarioDTO(
        @Schema(description = "Correo electrónico", example = "usuario@correo.com")
        String email,
        @Schema(description = "Nombres", example = "Miguel")
        String nombres,
        @Schema(description = "Apellidos", example = "Vega")
        String apellidos,
        @Schema(description = "Puesto profesional", example = "Backend Developer")
        String puesto,
        @JsonProperty("rol")
        @Schema(description = "Rol del usuario", example = "user")
        String rol,
        @Schema(description = "Estado de la cuenta (pendiente, activo o inactivo)", example = "activo")
        String estado
) {
}

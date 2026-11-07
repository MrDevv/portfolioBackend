package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Rol de un usuario")
public record ResponseRolDTO(
        @JsonProperty("rol_uuid")
        @Schema(description = "UUID del rol", example = "7a9d2c4e-1b3f-4a5c-8d6e-9f0a1b2c3d4e")
        String rolUUID,
        @Schema(description = "Descripción del rol", example = "admin")
        String descripcion
) {
}

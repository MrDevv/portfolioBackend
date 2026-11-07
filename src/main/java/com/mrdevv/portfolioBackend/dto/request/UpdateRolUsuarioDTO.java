package com.mrdevv.portfolioBackend.dto.request;

import com.mrdevv.portfolioBackend.utils.constants.Roles;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para actualizar el rol de un usuario")
public record UpdateRolUsuarioDTO(
        @Schema(description = "Nuevo rol del usuario (admin o user)", example = "user", requiredMode = Schema.RequiredMode.REQUIRED)
        Roles rol
) {
}

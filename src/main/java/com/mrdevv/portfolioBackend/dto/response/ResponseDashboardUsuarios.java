package com.mrdevv.portfolioBackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resumen de usuarios de la plataforma por estado")
public record ResponseDashboardUsuarios(
        @Schema(description = "Total de usuarios", example = "25")
        Long total,
        @Schema(description = "Usuarios con cuenta activa", example = "20")
        Long activos,
        @Schema(description = "Usuarios pendientes de verificar su correo", example = "3")
        Long pendientes,
        @Schema(description = "Usuarios con cuenta inactiva", example = "2")
        Long inactivos
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resumen general del dashboard de administración")
public record ResponseDashboard(
        @Schema(description = "Resumen de usuarios")
        ResponseDashboardUsuarios usuarios,
        @Schema(description = "Resumen de contenido")
        ResponseDashboardContenido contenido
) {
}

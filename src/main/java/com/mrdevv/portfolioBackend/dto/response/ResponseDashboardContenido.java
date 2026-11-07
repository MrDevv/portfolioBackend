package com.mrdevv.portfolioBackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resumen del contenido registrado en la plataforma")
public record ResponseDashboardContenido(
        @Schema(description = "Total de experiencias registradas", example = "42")
        Long experiencia,
        @Schema(description = "Total de proyectos registrados", example = "87")
        Long proyectos
) {
}

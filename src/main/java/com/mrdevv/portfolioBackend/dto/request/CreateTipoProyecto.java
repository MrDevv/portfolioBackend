package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para crear un tipo de proyecto")
public record CreateTipoProyecto(
        @Schema(description = "Descripción del tipo de proyecto", example = "Aplicación web")
        String descripcion
) {
}

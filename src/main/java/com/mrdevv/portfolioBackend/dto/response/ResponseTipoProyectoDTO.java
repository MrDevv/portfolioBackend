package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tipo de proyecto")
public record ResponseTipoProyectoDTO(
        @JsonProperty("tipo_proyecto_uuid")
        @Schema(description = "UUID del tipo de proyecto", example = "7a9d2c4e-1b3f-4a5c-8d6e-9f0a1b2c3d4e")
        String tipoProyectoUUID,
        @Schema(description = "Descripción del tipo de proyecto", example = "Aplicación web")
        String descripcion
) {
}

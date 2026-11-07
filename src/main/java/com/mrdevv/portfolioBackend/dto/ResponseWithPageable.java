package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta paginada")
public record ResponseWithPageable(
        @JsonProperty("content")
        @Schema(description = "Elementos de la página actual")
        Object data,
        @Schema(description = "Información de paginación")
        PageableData pageableData
) {
}

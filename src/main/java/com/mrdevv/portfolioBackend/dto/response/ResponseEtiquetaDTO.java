package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Etiqueta de un proyecto")
public record ResponseEtiquetaDTO(
        @JsonProperty("etiqueta_uuid")
        @Schema(description = "UUID de la etiqueta", example = "7a9d2c4e-1b3f-4a5c-8d6e-9f0a1b2c3d4e")
        String etiquetaUUID,
        @Schema(description = "Nombre de la etiqueta", example = "spring")
        String descripcion
) {
}

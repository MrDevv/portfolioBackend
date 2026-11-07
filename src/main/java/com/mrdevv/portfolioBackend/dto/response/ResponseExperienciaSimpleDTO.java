package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Experiencia profesional en formato resumido")
public record ResponseExperienciaSimpleDTO(
        @JsonProperty("experiencia_uuid")
        @Schema(description = "UUID de la experiencia", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String experienciaUUID,
        @Schema(description = "Título de la experiencia", example = "Desarrollador Backend")
        String titulo
) {
}

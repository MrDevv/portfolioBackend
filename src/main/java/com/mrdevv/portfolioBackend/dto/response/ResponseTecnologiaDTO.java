package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tecnología del catálogo")
public record ResponseTecnologiaDTO(
        @Schema(description = "UUID de la tecnología", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String tecnologiaUUID,
        @Schema(description = "Nombre de la tecnología", example = "Java")
        String tecnologia,
        @Schema(description = "URL del logo de la tecnología", example = "https://cdn.ejemplo.com/java.svg")
        String logoURL,
        @JsonProperty("tipoTecnologia")
        @Schema(description = "Tipo de tecnología")
        ResponseTipoTecnologiaDTO tipoTecnologiaDTO
) {
}

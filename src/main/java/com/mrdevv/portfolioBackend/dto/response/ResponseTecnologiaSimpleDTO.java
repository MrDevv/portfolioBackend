package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tecnología del catálogo en formato resumido")
public record ResponseTecnologiaSimpleDTO(
        @Schema(description = "Nombre de la tecnología", example = "Java")
        String descripcion,
        @JsonProperty("logo_url")
        @Schema(description = "URL del logo de la tecnología", example = "https://cdn.ejemplo.com/java.svg")
        String logoUrl,
        @JsonProperty("tipo_tecnologia")
        @Schema(description = "Tipo de tecnología", example = "Lenguaje de programación")
        String tipoTecnologia
) {
}

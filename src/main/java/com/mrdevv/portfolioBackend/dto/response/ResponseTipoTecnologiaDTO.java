package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tipo de tecnología")
public record ResponseTipoTecnologiaDTO(
        @JsonProperty("tipo_tecnologia_uuid")
        @Schema(description = "UUID del tipo de tecnología", example = "7a9d2c4e-1b3f-4a5c-8d6e-9f0a1b2c3d4e")
        String tipoTecnologiaUUID,
        @Schema(description = "Descripción del tipo de tecnología", example = "Lenguaje de programación")
        String descripcion
) {
}

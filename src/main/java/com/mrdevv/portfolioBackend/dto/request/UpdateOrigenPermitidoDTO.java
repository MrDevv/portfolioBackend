package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para configurar el origen permitido de la API key")
public record UpdateOrigenPermitidoDTO(
        @Schema(description = "Origen permitido (cabecera Origin)", example = "https://miportafolio.com")
        String origenPermitido,
        @Schema(description = "Indica si la restricción de origen está activa", example = "true")
        Boolean estado
) {
}

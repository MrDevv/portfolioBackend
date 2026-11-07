package com.mrdevv.portfolioBackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Tecnología asociada a un profesional")
public record ResponseProfesionalTecnologiaDTO(
        @Schema(description = "UUID de la relación profesional-tecnología", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String profesionalTecnologiaUUID,
        @Schema(description = "Nombre de la tecnología", example = "Java")
        String tecnologia,
        @Schema(description = "URL del logo de la tecnología", example = "https://cdn.ejemplo.com/java.svg")
        String logoURL,
        @Schema(description = "Tipo de tecnología", example = "Lenguaje de programación")
        String tipoTecnologia,
        @Schema(description = "Nivel de dominio", example = "intermedio")
        String nivel
) {
}

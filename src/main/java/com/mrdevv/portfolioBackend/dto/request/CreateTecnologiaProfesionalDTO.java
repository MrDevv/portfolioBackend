package com.mrdevv.portfolioBackend.dto.request;

import com.mrdevv.portfolioBackend.utils.constants.NivelTecnologia;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Datos para asociar una tecnología al profesional")
public record CreateTecnologiaProfesionalDTO(
        @NotBlank(message = "El campo tecnologiaUUID es requerido")
        @Schema(description = "UUID de la tecnología del catálogo", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34", requiredMode = Schema.RequiredMode.REQUIRED)
        String tecnologiaUUID,
        @Schema(description = "Nivel de dominio de la tecnología", example = "intermedio")
        NivelTecnologia nivel
) {
}

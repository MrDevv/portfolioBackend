package com.mrdevv.portfolioBackend.dto.request;

import com.mrdevv.portfolioBackend.utils.constants.NivelTecnologia;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para actualizar el nivel de una tecnología del profesional")
public record UpdateTecnologiaProfesionalDTO(
        @Schema(description = "Nuevo nivel de dominio (básico, intermedio o avanzado)", example = "avanzado")
        NivelTecnologia nivel
) {
}

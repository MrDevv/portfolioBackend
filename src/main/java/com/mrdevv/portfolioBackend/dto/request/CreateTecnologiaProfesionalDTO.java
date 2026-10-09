package com.mrdevv.portfolioBackend.dto.request;

import com.mrdevv.portfolioBackend.utils.constants.NivelTecnologia;
import jakarta.validation.constraints.NotBlank;

public record CreateTecnologiaProfesionalDTO (
        @NotBlank(message = "El campo tecnologiaUUID es requerido")
        String tecnologiaUUID,
        NivelTecnologia nivel
) {
}

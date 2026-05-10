package com.mrdevv.portfolioBackend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrdevv.portfolioBackend.utils.constants.NivelTecnologia;
import jakarta.validation.constraints.NotEmpty;

public record CreateTecnologiaProfesionalDTO (
        @NotEmpty(message = "El campo tecnologia_uuid es requerido")
        @JsonProperty("tecnologia_uuid")
        String tecnologiaUUID,
        NivelTecnologia nivel
) {
}

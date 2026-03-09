package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTecnologiaSimpleDTO(
        @JsonProperty("tecnologia_id")
        Long tecnologiaId,
        String descripcion,
        @JsonProperty("tipo_tecnologia")
        String tipoTecnologia
) {
}

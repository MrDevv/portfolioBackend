package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTecnologiaSimpleDTO(
        String descripcion,
        @JsonProperty("logo_url")
        String logoUrl,
        @JsonProperty("tipo_tecnologia")
        String tipoTecnologia
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTecnologiaDTO(
        String tecnologiaUUID,

        String tecnologia,

        String logoURL,

        @JsonProperty("tipoTecnologia")
        ResponseTipoTecnologiaDTO tipoTecnologiaDTO
) {
}

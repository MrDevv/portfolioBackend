package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTecnologiaDTO(
        @JsonProperty("tecnologia_uuid")
        String tecnologiaUUID,

        String tecnologia,

        @JsonProperty("logo_url")
        String logoUrl,

        @JsonProperty("tipo_tecnologia")
        ResponseTipoTecnologiaDTO tipoTecnologiaDTO
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTecnologiaDTO(
        @JsonProperty("tecnologia_id")
        Long tecnologiaId,

        String descripcion,

        @JsonProperty("logo_url")
        String logoUrl,

        @JsonProperty("tipo_tecnologia")
        ResponseTipoTecnologiaDTO tipoTecnologiaDTO
) {
}

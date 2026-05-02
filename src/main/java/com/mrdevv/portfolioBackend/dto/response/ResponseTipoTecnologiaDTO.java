package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ResponseTipoTecnologiaDTO(
        @JsonProperty("tipo_tecnologia_uuid")
        String tipoTecnologiaUUID,

        String descripcion
) {
}

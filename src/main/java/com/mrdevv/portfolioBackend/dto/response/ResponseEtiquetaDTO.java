package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ResponseEtiquetaDTO(
        @JsonProperty("etiqueta_uuid")
        UUID etiquetaUUID,
        String descripcion
) {
}

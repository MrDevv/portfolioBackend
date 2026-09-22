package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseEtiquetaDTO(
        @JsonProperty("etiqueta_uuid")
        String etiquetaUUID,
        String descripcion
) {
}

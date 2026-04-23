package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ResponseTipoProyectoDTO(
        @JsonProperty("tipo_proyecto_uuid")
        UUID tipoProyectoUUID,

        String descripcion
) {
}

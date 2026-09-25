package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record  ResponseTipoProyectoDTO(
        @JsonProperty("tipo_proyecto_uuid")
        String tipoProyectoUUID,

        String descripcion
) {
}

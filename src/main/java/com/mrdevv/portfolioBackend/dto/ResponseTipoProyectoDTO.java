package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTipoProyectoDTO(
        @JsonProperty("tipo_proyecto_id")
        Long tipoProyectoId,

        String descripcion
) {
}

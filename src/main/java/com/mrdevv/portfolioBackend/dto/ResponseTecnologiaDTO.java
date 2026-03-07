package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseTecnologiaDTO(
        @JsonProperty("tecnologia_id")
        Long tecnologiaId,

        String descripcion,

        @JsonProperty("tipo_tecnologia")
        ResponseTipoProyectoDTO tipoProyecto
) {
}

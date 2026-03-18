package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ResponseProyectoDTO(
        @JsonProperty("proyecto_id")
        Long proyectoId,
        String titulo,
        String descripcion,
        @JsonProperty("url_produccion")
        String urlProduccion,
        @JsonProperty("url_repositorio")
        String urlRepositorio,
        String estado,
        @JsonProperty("experiencia")
        ResponseExperienciaSimpleDTO experienciaSimpleDTO,
        @JsonProperty("tipo_proyecto")
        ResponseTipoProyectoDTO tipoProyectoDTO,
        @JsonProperty("etiquetas")
        List<ResponseEtiquetaDTO> etiquetaDTOS
) {
}

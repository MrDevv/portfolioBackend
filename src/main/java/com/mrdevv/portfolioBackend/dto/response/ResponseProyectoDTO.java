package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record ResponseProyectoDTO(
        @JsonProperty("proyecto_uuid")
        UUID proyectoUUID,
        String titulo,
        String descripcion,
        @JsonProperty("url_produccion")
        String urlProduccion,
        @JsonProperty("url_repositorio")
        String urlRepositorio,
        @JsonProperty("url_imagen_presentacion")
        String urlImagenPresentacion,
        String estado,
        @JsonProperty("experiencia")
        ResponseExperienciaSimpleDTO experienciaSimpleDTO,
        @JsonProperty("tipo_proyecto")
        ResponseTipoProyectoDTO tipoProyectoDTO,
        @JsonProperty("etiquetas")
        List<ResponseEtiquetaDTO> etiquetaDTOS
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Proyecto del profesional")
public record ResponseProyectoDTO(
        @JsonProperty("proyecto_uuid")
        @Schema(description = "UUID del proyecto", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String proyectoUUID,
        @Schema(description = "Título del proyecto", example = "Portafolio personal")
        String titulo,
        @Schema(description = "Descripción del proyecto", example = "API REST para gestionar un portafolio profesional")
        String descripcion,
        @JsonProperty("url_produccion")
        @Schema(description = "URL del proyecto en producción", example = "https://miproyecto.com")
        String urlProduccion,
        @JsonProperty("url_repositorio")
        @Schema(description = "URL del repositorio", example = "https://github.com/usuario/proyecto")
        String urlRepositorio,
        @JsonProperty("url_imagen_presentacion")
        @Schema(description = "URL de la imagen de presentación", example = "https://miproyecto.com/portada.png")
        String urlImagenPresentacion,
        @Schema(description = "Estado del proyecto", example = "activo")
        String estado,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("experiencia")
        @Schema(description = "Experiencia asociada. Se omite cuando no aplica")
        ResponseExperienciaSimpleDTO experienciaSimpleDTO,
        @JsonProperty("tipo_proyecto")
        @Schema(description = "Tipo de proyecto")
        ResponseTipoProyectoDTO tipoProyectoDTO,
        @JsonProperty("etiquetas")
        @Schema(description = "Etiquetas del proyecto")
        List<ResponseEtiquetaDTO> etiquetaDTOS
) {
}

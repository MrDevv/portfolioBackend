package com.mrdevv.portfolioBackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Datos para la creación de un proyecto")
public record CreateProyectoDTO(
        @NotBlank(message = "El titulo es obligatorio")
        @Schema(description = "Título del proyecto", example = "Portafolio personal", requiredMode = Schema.RequiredMode.REQUIRED)
        String titulo,
        @NotBlank(message = "La descripcion es obligatoria")
        @Schema(description = "Descripción del proyecto", example = "API REST para gestionar un portafolio profesional", requiredMode = Schema.RequiredMode.REQUIRED)
        String descripcion,
        @Schema(description = "URL del proyecto en producción", example = "https://miproyecto.com")
        String urlProduccion,
        @Schema(description = "URL del repositorio", example = "https://github.com/usuario/proyecto")
        String urlRepositorio,
        @Schema(description = "URL de la imagen de presentación", example = "https://miproyecto.com/portada.png")
        String urlImagenPresentacion,
        @NotBlank(message = "La experiencia es obligatoria")
        @Schema(description = "UUID de la experiencia asociada", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34", requiredMode = Schema.RequiredMode.REQUIRED)
        String experienciaUUID,
        @NotBlank(message = "El tipo de proyecto es obligatorio")
        @Schema(description = "UUID del tipo de proyecto", example = "7a9d2c4e-1b3f-4a5c-8d6e-9f0a1b2c3d4e", requiredMode = Schema.RequiredMode.REQUIRED)
        String tipoProyectoUUID,
        @Schema(description = "Nombres de las etiquetas del proyecto", example = "[\"spring\", \"java\"]")
        String[] etiquetas
) {
}

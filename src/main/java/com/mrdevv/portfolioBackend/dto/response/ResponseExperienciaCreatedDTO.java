package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Experiencia profesional creada")
public record ResponseExperienciaCreatedDTO(
        @JsonProperty("experiencia_uuid")
        @Schema(description = "UUID de la experiencia", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String experienciaUUID,
        @Schema(description = "Título de la experiencia", example = "Desarrollador Backend")
        String titulo,
        @Schema(description = "Descripción de las funciones realizadas", example = "Desarrollo de APIs REST con Spring Boot")
        String descripcion,
        @JsonProperty("fecha_inicio")
        @Schema(description = "Fecha de inicio (yyyy-MM-dd)", example = "2022-03-01")
        LocalDate fechaInicio,
        @JsonProperty("fecha_fin")
        @Schema(description = "Fecha de fin (yyyy-MM-dd). Es nula si la experiencia sigue vigente", example = "2024-06-30")
        LocalDate fechaFin,
        @JsonProperty("nombre_empresa")
        @Schema(description = "Nombre de la empresa", example = "Acme S.A.")
        String nombreEmpresa,
        @Schema(description = "Puesto desempeñado", example = "Backend Developer")
        String puesto
) {
}

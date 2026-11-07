package com.mrdevv.portfolioBackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;

@Schema(description = "Experiencia profesional junto con sus proyectos")
public record ResponseExperienciaConProyectosDTO(
        @Schema(description = "UUID de la experiencia", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String protectoUUID,
        @Schema(description = "Título de la experiencia", example = "Desarrollador Backend")
        String titulo,
        @Schema(description = "Descripción de las funciones realizadas", example = "Desarrollo de APIs REST con Spring Boot")
        String descripcion,
        @Schema(description = "Fecha de inicio (yyyy-MM-dd)", example = "2022-03-01")
        LocalDate fechaInicio,
        @Schema(description = "Fecha de fin (yyyy-MM-dd). Es nula si la experiencia sigue vigente", example = "2024-06-30")
        LocalDate fechaFin,
        @Schema(description = "Nombre de la empresa", example = "Acme S.A.")
        String nombreEmpresa,
        @Schema(description = "Puesto desempeñado", example = "Backend Developer")
        String puesto,
        @Schema(description = "Proyectos asociados a la experiencia")
        List<ResponseProyectoDTO> proyectos
) {
}

package com.mrdevv.portfolioBackend.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(description = "Datos para actualizar una experiencia profesional")
public record UpdateExperienceDTO(
        @NotNull(message = "El título de la experiencia es obligatorio")
        @Schema(description = "Título de la experiencia", example = "Desarrollador Backend", requiredMode = Schema.RequiredMode.REQUIRED)
        String titulo,
        @NotNull(message = "La descripción de la experiencia es obligatoria")
        @Schema(description = "Descripción de las funciones realizadas", example = "Desarrollo de APIs REST con Spring Boot", requiredMode = Schema.RequiredMode.REQUIRED)
        String descripcion,
        @NotNull(message = "La fecha de inicio de la experiencia es obligatoria")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @Schema(description = "Fecha de inicio (yyyy-MM-dd)", example = "2022-03-01", requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDate fechaInicio,
        @JsonFormat(pattern = "yyyy-MM-dd")
        @Schema(description = "Fecha de fin (yyyy-MM-dd). Se omite si la experiencia sigue vigente", example = "2024-06-30")
        LocalDate fechaFin,
        @NotNull(message = "El nombre de la empresa es obligatorio")
        @Schema(description = "Nombre de la empresa", example = "Acme S.A.", requiredMode = Schema.RequiredMode.REQUIRED)
        String nombreEmpresa,
        @NotNull(message = "El puesto es obligatorio")
        @Schema(description = "Puesto desempeñado", example = "Backend Developer", requiredMode = Schema.RequiredMode.REQUIRED)
        String puesto
) {
}

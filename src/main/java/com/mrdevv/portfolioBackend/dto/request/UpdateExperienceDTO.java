package com.mrdevv.portfolioBackend.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateExperienceDTO(
        @NotNull(message = "El título de la experiencia es obligatorio")
        String titulo,
        @NotNull(message = "La descripción de la experiencia es obligatoria")
        String descripcion,
        @NotNull(message = "La fecha de inicio de la experiencia es obligatoria")
        @JsonProperty("fecha_inicio")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate fechaInicio,
        @JsonProperty("fecha_fin")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate fechaFin,
        @NotNull(message = "El nombre de la empresa es obligatorio")
        @JsonProperty("nombre_empresa")
        String nombreEmpresa,
        @NotNull(message = "El puesto es obligatorio")
        String puesto
) {
}
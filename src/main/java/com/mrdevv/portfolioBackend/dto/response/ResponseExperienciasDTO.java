package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ResponseExperienciasDTO(
        @JsonProperty("experiencia_id")
        Long experienciaId,
        String titulo,
        String descripcion,
        @JsonProperty("fecha_inicio")
        LocalDate fechaInicio,
        @JsonProperty("fecha_fin")
        LocalDate fechaFin,
        @JsonProperty("nombre_empresa")
        String nombreEmpresa,
        String desarrollador
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ResponseExperienciaDTO(
        @JsonProperty("experiencia_uuid")
        String experienciaUUID,
        String titulo,
        String descripcion,
        @JsonProperty("fecha_inicio")
        LocalDate fechaInicio,
        @JsonProperty("fecha_fin")
        LocalDate fechaFin,
        @JsonProperty("nombre_empresa")
        String nombreEmpresa,
        String puesto
) {
}

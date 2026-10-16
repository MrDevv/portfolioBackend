package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ResponseExperienciaDTO(
        String experienciaUUID,
        String titulo,
        String descripcion,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreEmpresa,
        String puesto
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ResponseExperienciaDetailDTO(
        String experienciaUUID,
        String titulo,
        String descripcion,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreEmpresa,
        String puesto,
        String profesional,
        Long cantidadProyectos
) {
}

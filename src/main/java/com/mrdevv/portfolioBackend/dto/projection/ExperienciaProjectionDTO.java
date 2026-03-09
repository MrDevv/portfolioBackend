package com.mrdevv.portfolioBackend.dto.projection;

import java.time.LocalDate;

public record ExperienciaProjectionDTO(
        Long experienciaId,
        String descripcion,
        String titulo,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreEmpresa,
        String nombres,
        String apellidos
) {
}

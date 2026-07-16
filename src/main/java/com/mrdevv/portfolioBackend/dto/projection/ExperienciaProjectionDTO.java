package com.mrdevv.portfolioBackend.dto.projection;

import java.time.LocalDate;

public record ExperienciaProjectionDTO(
        String experienciaUUID,
        String descripcion,
        String titulo,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreEmpresa,
        String puesto,
        String nombres,
        String apellidos,
        Long cantidadProyectos
) {
}

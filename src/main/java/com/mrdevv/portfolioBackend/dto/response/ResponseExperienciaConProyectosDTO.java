package com.mrdevv.portfolioBackend.dto.response;

import java.time.LocalDate;
import java.util.List;

public record ResponseExperienciaConProyectosDTO(
        String protectoUUID,
        String titulo,
        String descripcion,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String nombreEmpresa,
        String puesto,
        List<ResponseProyectoDTO> proyectos
) {
}

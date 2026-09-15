package com.mrdevv.portfolioBackend.dto.projection;

import java.time.LocalDate;
import java.util.List;

public interface ExperienciaConProyectosProjectionDTO {

    String getExperienciaUUID();
    String getDescripcion();
    String getTitulo();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    String getNombreEmpresa();
    String getPuesto();
    List<ProyectoSinExperienciaProjectionDTO> getProyectos();

}

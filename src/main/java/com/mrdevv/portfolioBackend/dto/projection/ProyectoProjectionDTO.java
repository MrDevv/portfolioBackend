package com.mrdevv.portfolioBackend.dto.projection;

import java.util.List;

public interface ProyectoProjectionDTO {

    Long getProyectoId();

    String getTitulo();

    String getDescripcion();

    String getUrlProduccion();

    String getUrlRepositorio();

    String getUrlImagenPresentacion();

    Boolean getEstado();

    ExperienciaProjectionSimpleDTO getExperiencia();

    TipoProyectoProjectionSimpleDTO getTipoProyecto();

    List<EtiquetaProjectionDTO> getEtiquetas();
}

package com.mrdevv.portfolioBackend.dto.projection;

import java.util.List;
import java.util.UUID;

public interface ProyectoProjectionDTO {

    UUID getProyectoUUID();

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

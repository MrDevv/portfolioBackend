package com.mrdevv.portfolioBackend.dto.projection;

import java.util.List;

public interface ProyectoSinExperienciaProjectionDTO {

    String getProyectoUUID();

    String getTitulo();

    String getDescripcion();

    String getUrlProduccion();

    String getUrlRepositorio();

    String getUrlImagenPresentacion();

    Boolean getEstado();

    TipoProyectoProjectionSimpleDTO getTipoProyecto();

    List<EtiquetaProjectionDTO> getEtiquetas();
}

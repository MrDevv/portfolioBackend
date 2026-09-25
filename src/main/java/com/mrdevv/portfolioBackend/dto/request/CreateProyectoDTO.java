package com.mrdevv.portfolioBackend.dto.request;

public record CreateProyectoDTO(
        String titulo,
        String descripcion,
        String urlProduccion,
        String urlRepositorio,
        String urlImagenPresentacion,
        String experienciaUUID,
        String tipoProyectoUUID,
        String[] etiquetas
) {
}

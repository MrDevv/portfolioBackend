package com.mrdevv.portfolioBackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProyectoDTO(
        @NotBlank(message = "El titulo es obligatorio")
        String titulo,
        @NotBlank(message = "La descripcion es obligatoria")
        String descripcion,
        String urlProduccion,
        String urlRepositorio,
        String urlImagenPresentacion,
        @NotBlank(message = "La experiencia es obligatoria")
        String experienciaUUID,
        @NotBlank(message = "El tipo de proyecto es obligatorio")
        String tipoProyectoUUID,
        String[] etiquetas
) {
}

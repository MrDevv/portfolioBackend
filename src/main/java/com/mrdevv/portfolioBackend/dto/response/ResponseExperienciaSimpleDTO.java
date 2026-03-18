package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseExperienciaSimpleDTO(
        @JsonProperty("experiencia_id")
        Long experienciaId,
        String titulo
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ResponseExperienciaSimpleDTO(
        @JsonProperty("experiencia_uuid")
        UUID experienciaUUID,
        String titulo
) {
}

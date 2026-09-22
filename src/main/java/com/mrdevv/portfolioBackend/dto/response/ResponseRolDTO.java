package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseRolDTO(
        @JsonProperty("rol_uuid")
        String rolUUID,
        String descripcion
) {
}

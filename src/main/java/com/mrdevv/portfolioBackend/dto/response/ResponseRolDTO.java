package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ResponseRolDTO(
        @JsonProperty("rol_uuid")
        UUID rolUUID,
        String descripcion
) {
}

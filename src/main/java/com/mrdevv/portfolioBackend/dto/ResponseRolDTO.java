package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseRolDTO(
        @JsonProperty("rol_id")
        Long rolId,
        String descripcion
) {
}

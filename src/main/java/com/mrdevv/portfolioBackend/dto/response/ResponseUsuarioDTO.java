package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseUsuarioDTO(
        String email,
        String nombres,
        String apellidos,
        String puesto,
        @JsonProperty("rol")
        String rol,
        String estado
) {
}

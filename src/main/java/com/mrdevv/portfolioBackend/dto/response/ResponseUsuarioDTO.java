package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseUsuarioDTO(
        @JsonProperty("usuario_id")
        Long usuarioId,
        String username,
        String nombres,
        String apellidos,
        String puesto,
        @JsonProperty("rol")
        ResponseRolDTO rolDTO,
        String estado,
        @JsonProperty("api_key")
        String apiKey
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ResponseUsuarioLoginDTO(
        @JsonProperty("usuario_uuid")
        UUID usuarioUUid,
        String email,
        String nombres,
        String apellidos,
        String puesto,
        @JsonProperty("rol")
        ResponseRolDTO rolDTO,
        String estado,
        String token,
        @JsonProperty("api_key")
        String apiKey
) {
}

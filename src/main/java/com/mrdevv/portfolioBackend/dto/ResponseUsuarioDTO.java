package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

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
        @JsonProperty("token_acceso_front")
        String tokenAccesoFront
) {
}

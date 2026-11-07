package com.mrdevv.portfolioBackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "API key generada para el usuario")
public record ResponseApiKeyUsuario(
        @Schema(description = "API key. Solo se muestra una vez, al generarla", example = "dv_3f2b8c1e5d4a4e7b9a1c2b6d8e0f1a34")
        String apiKey
) {
}

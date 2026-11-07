package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos del usuario autenticado y su token de acceso")
public record ResponseUsuarioLoginDTO(
        @JsonProperty("usuario_uuid")
        @Schema(description = "UUID del usuario", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String usuarioUUid,
        @Schema(description = "Correo electrónico", example = "usuario@correo.com")
        String email,
        @Schema(description = "Nombres", example = "Miguel")
        String nombres,
        @Schema(description = "Apellidos", example = "Vega")
        String apellidos,
        @Schema(description = "Puesto profesional", example = "Backend Developer")
        String puesto,
        @JsonProperty("logo_url")
        @Schema(description = "URL del logo o foto de perfil", example = "https://miportafolio.com/logo.png")
        String logoUrl,
        @JsonProperty("rol")
        @Schema(description = "Rol del usuario")
        ResponseRolDTO rolDTO,
        @Schema(description = "Estado de la cuenta (pendiente, activo o inactivo)", example = "activo")
        String estado,
        @Schema(description = "Token JWT para autenticarse en los demás endpoints", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvIn0.firma")
        String token,
        @JsonProperty("api_key")
        @Schema(description = "API key del usuario. Es nula si no ha generado una", example = "dv_3f2b8c1e5d4a4e7b9a1c2b6d8e0f1a34")
        String apiKey,
        @JsonProperty("origen_permitido")
        @Schema(description = "Origen permitido para usar la API key", example = "https://miportafolio.com")
        String origenPermitido,
        @JsonProperty("estado_origen")
        @Schema(description = "Indica si la restricción de origen está activa", example = "true")
        String estadoOrigen
) {
}

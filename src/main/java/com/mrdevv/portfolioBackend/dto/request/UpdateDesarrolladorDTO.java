package com.mrdevv.portfolioBackend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateDesarrolladorDTO(
        String nombres,
        String apellidos,
        String correo,
        @JsonProperty("github_url")
        String githubUrl,
        @JsonProperty("linkedin_url")
        String linkedinUrl,
        @JsonProperty("cv_url")
        String cvUrl,
        @JsonProperty("prefijo_telefono")
        String prefijoTelefono,
        String telefono,
        String biografia,
        String puesto
) {
}

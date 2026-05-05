package com.mrdevv.portfolioBackend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateProfesionalDTO(
        String nombres,
        String apellidos,
        @JsonProperty("correo_contacto")
        String correoContacto,
        @JsonProperty("github_url")
        String githubUrl,
        @JsonProperty("linkedin_url")
        String linkedinUrl,
        @JsonProperty("cv_url")
        String cvUrl,
        @JsonProperty("logo_url")
        String logoUrl,
        @JsonProperty("prefijo_telefono")
        String prefijoTelefono,
        String telefono,
        String biografia,
        String puesto
) {
}

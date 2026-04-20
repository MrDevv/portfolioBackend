package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({
        "desarrollador_uuid", "nombres", "apellidos", "correo_contacto", "github_url", "linkedin_url", "cv_url", "logo_url", "prefijo_telefono", "telefono", "biografia", "puesto"})
public record ResponseDesarrolladorDTO(
        @JsonProperty("desarrollador_uuid")
        UUID desarrolladorUUID,
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

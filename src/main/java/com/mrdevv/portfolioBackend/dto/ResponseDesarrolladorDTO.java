package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "desarrollador_id", "nombres", "apellidos", "correo", "github_url", "linkedin_url", "cv_url", "prefijo_telefono", "telefono", "biografia", "puesto"})
public record ResponseDesarrolladorDTO(
        @JsonProperty("desarrollador_id")
        Long desarrolladorId,
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

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({
        "profesional_uuid", "nombres", "apellidos", "correo_contacto", "github_url", "linkedin_url", "cv_url", "logo_url", "prefijo_telefono", "telefono", "biografia", "puesto"})
@Schema(description = "Datos profesionales del usuario")
public record ResponseProfesionalDTO(
        @JsonProperty("profesional_uuid")
        @Schema(description = "UUID del profesional", example = "3f2b8c1e-5d4a-4e7b-9a1c-2b6d8e0f1a34")
        String profesionalUUID,
        @Schema(description = "Nombres", example = "Miguel")
        String nombres,
        @Schema(description = "Apellidos", example = "Vega")
        String apellidos,
        @JsonProperty("correo_contacto")
        @Schema(description = "Correo de contacto", example = "contacto@correo.com")
        String correoContacto,
        @JsonProperty("github_url")
        @Schema(description = "URL del perfil de GitHub", example = "https://github.com/usuario")
        String githubUrl,
        @JsonProperty("linkedin_url")
        @Schema(description = "URL del perfil de LinkedIn", example = "https://linkedin.com/in/usuario")
        String linkedinUrl,
        @JsonProperty("cv_url")
        @Schema(description = "URL del currículum", example = "https://miportafolio.com/cv.pdf")
        String cvUrl,
        @JsonProperty("logo_url")
        @Schema(description = "URL del logo o foto de perfil", example = "https://miportafolio.com/logo.png")
        String logoUrl,
        @JsonProperty("prefijo_telefono")
        @Schema(description = "Prefijo telefónico", example = "+51")
        String prefijoTelefono,
        @Schema(description = "Número de teléfono", example = "987654321")
        String telefono,
        @Schema(description = "Biografía profesional", example = "Desarrollador backend con experiencia en Java y Spring Boot.")
        String biografia,
        @Schema(description = "Puesto profesional", example = "Backend Developer")
        String puesto
) {
}

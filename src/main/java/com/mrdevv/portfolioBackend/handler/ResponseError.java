package com.mrdevv.portfolioBackend.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

@JsonPropertyOrder({"status", "code", "url", "method", "message", "backend_message", "timestamp", "details"})
@Schema(description = "Respuesta de error estándar de la API")
public record ResponseError(
        @Schema(description = "Estado de la respuesta", example = "Failed")
        String status,
        @JsonProperty("code")
        @Schema(description = "Código de estado HTTP", example = "404")
        int httCode,
        @Schema(description = "URL de la petición", example = "http://localhost:8080/me/proyectos/123")
        String url,
        @JsonProperty("method")
        @Schema(description = "Método HTTP de la petición", example = "GET")
        String httpMethod,
        @Schema(description = "Mensaje para mostrar al usuario", example = "No se encontró el proyecto")
        String message,
        @JsonProperty("backend_message")
        @Schema(description = "Mensaje técnico", example = "Project not found")
        String backendMessage,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        @Schema(description = "Fecha y hora del error", example = "06/11/2026 10:30")
        LocalDateTime timestamp,
        @Schema(description = "Detalle de los errores de validación. Es nulo si no aplica")
        List<String> details
) {
}

package com.mrdevv.portfolioBackend.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseDesarrolladorTecnologia(
        String tecnologia,
        @JsonProperty("logo_url")
        String logoUrl,
        @JsonProperty("tipo_tecnologia")
        String tipoTecnologia,
        String nivel
) {
}

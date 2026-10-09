package com.mrdevv.portfolioBackend.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseProfesionalTecnologiaDTO(
        String profesionalTecnologiaUUID,
        String tecnologia,
        String logoURL,
        String tipoTecnologia,
        String nivel
) {
}

package com.mrdevv.portfolioBackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseApiKeyUsuario(
        @JsonProperty("api_key")
        String apiKey
) {
}

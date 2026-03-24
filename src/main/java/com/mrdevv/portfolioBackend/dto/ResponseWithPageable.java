package com.mrdevv.portfolioBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ResponseWithPageable(
        @JsonProperty("content")
        Object data,
        PageableData pageableData
) {
}

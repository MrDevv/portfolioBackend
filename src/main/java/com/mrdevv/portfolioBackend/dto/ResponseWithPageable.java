package com.mrdevv.portfolioBackend.dto;

public record ResponseWithPageable(
        Object data,
        PageableData pageableData
) {
}

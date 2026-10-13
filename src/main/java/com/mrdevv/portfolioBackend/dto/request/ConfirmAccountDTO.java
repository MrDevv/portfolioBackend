package com.mrdevv.portfolioBackend.dto.request;


import jakarta.validation.constraints.NotBlank;

public record ConfirmAccountDTO(
    @NotBlank
    String token
) {
}

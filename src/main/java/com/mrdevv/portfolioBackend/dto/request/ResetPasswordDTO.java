package com.mrdevv.portfolioBackend.dto.request;

public record ResetPasswordDTO(
        String token,
        String password
) {
}

package com.mrdevv.portfolioBackend.dto.response;

public record ResponseDashboardUsuarios(
        Long total,
        Long activos,
        Long pendientes,
        Long inactivos
) {
}
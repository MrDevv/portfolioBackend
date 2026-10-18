package com.mrdevv.portfolioBackend.dto.projection;

public interface UsuarioResumenProjection {

    Long getTotalUsuarios();
    Long getTotalActivos();
    Long getTotalPendientes();
    Long getTotalInactivos();
}

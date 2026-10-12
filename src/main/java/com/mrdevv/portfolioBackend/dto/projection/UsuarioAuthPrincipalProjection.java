package com.mrdevv.portfolioBackend.dto.projection;

public interface UsuarioAuthPrincipalProjection {
    Long getUsuarioId();

    Long getProfesionalId();

    String getEmail();

    String getOrigenPermitido();

    Boolean getEstadoOrigen();

    String getRol();
}

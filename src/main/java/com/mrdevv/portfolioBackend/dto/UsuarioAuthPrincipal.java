package com.mrdevv.portfolioBackend.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record UsuarioAuthPrincipal(
        Long usuarioId,
        Long profesionalId,
        String email,
        String origenPermitido,
        Boolean estadoOrigen,
        Collection<? extends GrantedAuthority> authorities
) {
}

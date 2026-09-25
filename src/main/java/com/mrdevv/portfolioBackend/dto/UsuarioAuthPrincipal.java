package com.mrdevv.portfolioBackend.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record UsuarioAuthPrincipal(
        Long usuarioId,
        Long profesionalId,
        String email,
        Collection<? extends GrantedAuthority> authorities
) {
}

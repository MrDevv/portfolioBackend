package com.mrdevv.portfolioBackend.services.auth;

import com.mrdevv.portfolioBackend.exceptions.ApiKeyInvalidException;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApiKeyService {

    private final UsuarioRepository usuarioRepository;

    public boolean esApiKeyValida(String apiKey){
        return usuarioRepository.existsByApiKey(apiKey);
    }

}

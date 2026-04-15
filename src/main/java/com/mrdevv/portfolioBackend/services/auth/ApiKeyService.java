package com.mrdevv.portfolioBackend.services.auth;

import com.mrdevv.portfolioBackend.exceptions.ApiKeyInvalidException;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ApiKeyService {

    private final UsuarioRepository usuarioRepository;

    public Optional<Usuario> obtenerUsuarioPorApiKey(String apiKey){
        return usuarioRepository.findByApiKey(apiKey);
    }

}

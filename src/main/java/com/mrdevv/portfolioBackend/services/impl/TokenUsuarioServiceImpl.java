package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.models.TokenUsuario;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.TokenUsuarioRepository;
import com.mrdevv.portfolioBackend.services.ITokenUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class TokenUsuarioServiceImpl implements ITokenUsuarioService {

    private final TokenUsuarioRepository tokenUsuarioRepository;

    @Transactional
    @Override
    public void registrarTokenUsuario(String token, Usuario usuario, String tipoToken, LocalDateTime fechaExpiracion) {
        TokenUsuario tokenUsuario = TokenUsuario.builder()
                .token(token)
                .usuario(usuario)
                .tipoToken(tipoToken)
                .fechaExpiracion(fechaExpiracion)
                .build();
        tokenUsuarioRepository.save(tokenUsuario);
    }
}

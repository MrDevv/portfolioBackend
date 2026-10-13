package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.exceptions.ExpiredTokenUsuario;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.models.TokenUsuario;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.TokenUsuarioRepository;
import com.mrdevv.portfolioBackend.services.ITokenUsuarioService;
import com.mrdevv.portfolioBackend.services.IUsuarioService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class TokenUsuarioServiceImpl implements ITokenUsuarioService {

    private final TokenUsuarioRepository tokenUsuarioRepository;
    private final IUsuarioService usuarioService;

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

    @Transactional
    @Override
    public void confirmarTokenUsuario(String token) {
        TokenUsuario tokenUsuario = tokenUsuarioRepository.obtenerTokenUsuario(token, "CONFIRMAR_CUENTA");
        if (tokenUsuario == null) {
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_TOKEN_USUARIO_FRONT.getMessage(),
                    ErrorMessage.NOT_FOUND_TOKEN_USUARIO_BACKEND.getMessage()
            );
        }

        if (tokenUsuario.getFechaExpiracion().isBefore(LocalDateTime.now())) {
            throw new ExpiredTokenUsuario(
                    ErrorMessage.EXPIRED_TOKEN_USUARIO_BACKEND.getMessage(),
                    ErrorMessage.EXPIRED_TOKEN_USUARIO_FRONT.getMessage()
            );
        }

        Usuario usuario = tokenUsuario.getUsuario();
        usuarioService.activarCuentaUsuario(usuario.getUsuarioId());
        tokenUsuarioRepository.delete(tokenUsuario);
    }
}

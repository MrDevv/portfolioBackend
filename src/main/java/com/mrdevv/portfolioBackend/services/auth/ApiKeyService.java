package com.mrdevv.portfolioBackend.services.auth;

import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ApiKeyService {

    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Optional<UsuarioAuthPrincipal> obtenerUsuarioPorApiKey(String apiKey){
        return usuarioRepository.findUsuarioAuthPrincipalProjectionByApiKey(apiKey)
                .map(projection -> new UsuarioAuthPrincipal(
                        projection.getUsuarioId(),
                        projection.getProfesionalId(),
                        projection.getEmail(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + projection.getRol()))
                ));
    }

}

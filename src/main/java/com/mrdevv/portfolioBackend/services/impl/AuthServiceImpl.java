package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.UsuarioMapper;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import com.mrdevv.portfolioBackend.services.IAuthService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;

    @Transactional
    @Override
    public ResponseUsuarioLoginDTO login(AuthDTO authDTO) {
        Authentication usuarioRequest = new UsernamePasswordAuthenticationToken(
                authDTO.username(),
                authDTO.password()
        );

        try{
            Authentication authentication = authenticationManager.authenticate(usuarioRequest);
            return UsuarioMapper.toResponseUsuarioLogin((Usuario) authentication.getPrincipal(), null);
        }catch (BadCredentialsException exception){
            throw new BadCredentialsException("Usuario o contraseña incorrectas");
        }
    }
}

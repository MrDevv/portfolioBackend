package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.request.RegisterDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.exceptions.AccountNotEnabledException;
import com.mrdevv.portfolioBackend.exceptions.PasswordNotMatchException;
import com.mrdevv.portfolioBackend.mappers.UsuarioMapper;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.IAuthService;
import com.mrdevv.portfolioBackend.services.auth.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioServiceImpl usuarioService;

    private final HttpServletRequest httpServletReq;

    @Transactional(readOnly = true)
    @Override
    public ResponseUsuarioLoginDTO login(AuthDTO authDTO) {
        Authentication usuarioRequest = new UsernamePasswordAuthenticationToken(
                authDTO.email(),
                authDTO.password()
        );

        try{
            Authentication authentication = authenticationManager.authenticate(usuarioRequest);
            Usuario usuario = (Usuario) authentication.getPrincipal();

            if (usuario.getEstado().equalsIgnoreCase("pendiente")){
                throw new AccountNotEnabledException("auth_error", "EMAIL_NOT_VERIFIED");
            } else if (usuario.getEstado().equalsIgnoreCase("inactivo")){
                throw new AccountNotEnabledException("auth_error", "ACCOUNT_INACTIVE");
            }

            String jwt = jwtService.generarToken(usuario);
            return UsuarioMapper.toResponseUsuarioLogin(usuario, jwt);
        }catch (BadCredentialsException exception){
            throw new BadCredentialsException("Usuario o contraseña incorrectas");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseUsuarioLoginDTO validateToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String token = httpServletReq.getHeader("Authorization").split(" ")[1];
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return UsuarioMapper.toResponseUsuarioLogin(usuario, token);
    }

    @Transactional
    @Override
    public void register(RegisterDTO registerDTO) {
        if (!isPasswordConfirmed(registerDTO.password(), registerDTO.confirmarPassword())) {
            throw new PasswordNotMatchException("La contraseña y la confirmación de contraseña no coinciden", "Las contraseñas no coinciden");
        }
        usuarioService.createUsuario(registerDTO);
    }

    private boolean isPasswordConfirmed(String password, String confirmarPassword){
        return password.equals(confirmarPassword);
    }
}

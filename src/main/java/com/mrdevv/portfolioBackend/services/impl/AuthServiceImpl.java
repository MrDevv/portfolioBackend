package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.request.AuthDTO;
import com.mrdevv.portfolioBackend.dto.request.RegisterDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.exceptions.AccountNotEnabledException;
import com.mrdevv.portfolioBackend.exceptions.PasswordNotMatchException;
import com.mrdevv.portfolioBackend.mappers.UsuarioMapper;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.IAuthService;
import com.mrdevv.portfolioBackend.services.ITokenUsuarioService;
import com.mrdevv.portfolioBackend.services.auth.JwtService;
import com.mrdevv.portfolioBackend.services.mail.IMailService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioServiceImpl usuarioService;
    private final ITokenUsuarioService tokenUsuarioService;
    private final IMailService mailService;

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
        Usuario usuario = usuarioService.createUsuario(registerDTO);
        String token = generarToken();
        tokenUsuarioService.registrarTokenUsuario(token, usuario, "CONFIRMAR_CUENTA", LocalDateTime.now().plusHours(24));
        mailService.enviarCorreoConfirmacionCuenta(token, registerDTO.email());
    }

    private boolean isPasswordConfirmed(String password, String confirmarPassword){
        return password.equals(confirmarPassword);
    }

    private String generarToken() {
        LocalDateTime fechaActual = LocalDateTime.now();
        String day = String.valueOf(fechaActual.getDayOfMonth());
        String month = String.valueOf(fechaActual.getMonthValue());
        String year = String.valueOf(fechaActual.getYear());
        String hour = String.valueOf(fechaActual.getHour());
        String uuid = java.util.UUID.randomUUID().toString();
        return uuid.concat("-").concat(day).concat(month).concat(year).concat(hour);
    }
}

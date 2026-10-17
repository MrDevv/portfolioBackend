package com.mrdevv.portfolioBackend.config.security.filters;

import com.mrdevv.portfolioBackend.config.security.handler.CustomAuthenticationEntryPoint;
import com.mrdevv.portfolioBackend.config.security.handler.CustomDeniedEntryPoint;
import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.auth.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    private final ApiKeyService apiKeyService;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomDeniedEntryPoint deniedEntryPoint;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().contains("/dev/me");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            request.setAttribute("auth_error", "API_KEY_MISSING");
            authenticationEntryPoint.commence(
                    request,
                    response,
                    new InsufficientAuthenticationException("API_KEY faltante")
            );
        }

        String apiKey = authorizationHeader.split(" ")[1];

        Optional<UsuarioAuthPrincipal> usuario = apiKeyService.obtenerUsuarioPorApiKey(apiKey);

        if(usuario.isEmpty()){
            request.setAttribute("auth_error", "API_KEY_INVALID");

            authenticationEntryPoint.commence(
                    request,
                    response,
                    new InsufficientAuthenticationException("API_KEY invalida")
            );

            return;
        };

        if (usuario.get().estado().equalsIgnoreCase("pendiente")){
            request.setAttribute("auth_error", "EMAIL_NOT_VERIFIED");
            deniedEntryPoint.handle(request, response, new AccessDeniedException("Email no verificado"));
            return;
        } else if (usuario.get().estado().equalsIgnoreCase("inactivo")){
            request.setAttribute("auth_error", "ACCOUNT_INACTIVE");
            deniedEntryPoint.handle(request, response, new AccessDeniedException("Cuenta inactiva"));
            return;
        }

        String origenPeticion = request.getHeader("Origin");
        String origenPermitido = usuario.get().origenPermitido();

        if (origenPermitido != null) {
            if (!origenPermitido.equals(origenPeticion) && usuario.get().estadoOrigen()) {
                deniedEntryPoint.handle(request, response, new AccessDeniedException("Origen no permitido"));
                return;
            }
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                usuario.get(), null, null
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

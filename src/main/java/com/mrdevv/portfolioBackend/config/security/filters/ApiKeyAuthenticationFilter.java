package com.mrdevv.portfolioBackend.config.security.filters;

import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.auth.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
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

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().contains("/desarrolladores/me");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            request.setAttribute("auth_error", "API_KEY_MISSING");
            throw new InsufficientAuthenticationException("API_KEY faltante");
        }

        String apiKey = authorizationHeader.split(" ")[1];

        Optional<Usuario> usuario = apiKeyService.obtenerUsuarioPorApiKey(apiKey);

        if(usuario.isEmpty()){
            request.setAttribute("auth_error", "API_KEY_INVALID");
            throw new InsufficientAuthenticationException("API_KEY invalida");
        };

        Long usuarioId = usuario.get().getUsuarioId();

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                usuarioId, null, null
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

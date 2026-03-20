package com.mrdevv.portfolioBackend.config.security.filters;

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

@RequiredArgsConstructor
@Component
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    private final ApiKeyService apiKeyService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().contains("/public");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            request.setAttribute("auth_error", "API_KEY_MISSING");
            throw new InsufficientAuthenticationException("API_KEY faltante");
        }

        String apiKey = authorizationHeader.split(" ")[1];

        if(!apiKeyService.esApiKeyValida(apiKey)){
            request.setAttribute("auth_error", "API_KEY_INVALID");
            throw new InsufficientAuthenticationException("API_KEY invalida");
        };

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                apiKey, null, null
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

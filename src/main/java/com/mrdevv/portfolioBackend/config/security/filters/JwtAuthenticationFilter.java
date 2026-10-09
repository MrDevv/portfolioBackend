package com.mrdevv.portfolioBackend.config.security.filters;

import com.mrdevv.portfolioBackend.config.security.handler.CustomAuthenticationEntryPoint;
import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.services.auth.JwtService;
import com.mrdevv.portfolioBackend.services.impl.UsuarioServiceImpl;
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
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioServiceImpl usuarioService;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return (request.getRequestURI().contains("/auth") && !request.getRequestURI().contains("/auth/validate-token")) || request.getRequestURI().contains("/dev/me");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt;
        String email;
        UsuarioAuthPrincipal usuarioAutenticado;

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            request.setAttribute("auth_error", "JWT_MISSING");
            authenticationEntryPoint.commence(
                    request,
                    response,
                    new InsufficientAuthenticationException("JWT faltante")
            );

            return;
        }

        jwt = authorizationHeader.split(" ")[1];

        try{
            email = jwtService.extractEmail(jwt);
        }catch (Exception e){
            request.setAttribute("auth_error", "JWT_INVALID");

            authenticationEntryPoint.commence(
                    request,
                    response,
                    new InsufficientAuthenticationException("JWT invalido")
            );

            return;
        }


        if (request.getRequestURI().contains("auth/validate-token")){
            Usuario usuario = usuarioService.findByEmail(email);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    usuario, null, usuario.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
            return;
        }

        usuarioAutenticado = usuarioService.findUsuarioAuthPrincipalProjectionByEmail(email);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                usuarioAutenticado, null, usuarioAutenticado.authorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

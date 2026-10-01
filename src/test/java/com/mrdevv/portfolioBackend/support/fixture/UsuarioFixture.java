package com.mrdevv.portfolioBackend.support.fixture;

import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.ProfesionalRepository;
import com.mrdevv.portfolioBackend.repositories.RolRepository;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioFixture {

    private final UsuarioRepository usuarioRepository;
    private final ProfesionalRepository profesionalRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfesionalFixture profesionalFixture;

    public Usuario crearUsuario(String email, String password, String apiKey, String rolDescripcion, Profesional profesional) {

        Rol rol = rolRepository.buscarRolPorDescripcion(rolDescripcion).orElseThrow();

        return usuarioRepository.save(Usuario.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .apiKey(apiKey)
                .rol(rol)
                .profesional(profesional)
                .build());
    }
}

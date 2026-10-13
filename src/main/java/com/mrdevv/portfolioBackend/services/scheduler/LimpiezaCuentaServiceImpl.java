package com.mrdevv.portfolioBackend.services.scheduler;

import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.ProfesionalRepository;
import com.mrdevv.portfolioBackend.repositories.TokenUsuarioRepository;
import com.mrdevv.portfolioBackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LimpiezaCuentaServiceImpl implements ILimpiezaCuentaService{

    private final UsuarioRepository usuarioRepository;
    private final TokenUsuarioRepository tokenUsuarioRepository;
    private final ProfesionalRepository profesionalRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Long> obtenerCandidatos(LocalDateTime ahora) {
        return usuarioRepository.obtenerIdsPendientesConTokenVencido(ahora);
    }

    @Transactional
    @Override
    public boolean eliminarCuenta(Long usuarioId, LocalDateTime ahora) {
        Usuario usuario = usuarioRepository.obtenerPendienteVencidoConBloqueo(usuarioId, ahora).orElse(null);

        if (usuario == null) {
            return false;
        }

        Profesional profesional = usuario.getProfesional();

        // elimina todos los tokens asociados a esta cuenta.
        tokenUsuarioRepository.eliminarPorUsuario(usuarioId);

        // elimina el usuario
        usuarioRepository.delete(usuario);

        if (profesional != null) {
            profesionalRepository.delete(profesional);
        }

        return true;
    }
}

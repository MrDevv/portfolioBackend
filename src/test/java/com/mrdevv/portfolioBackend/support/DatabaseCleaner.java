package com.mrdevv.portfolioBackend.support;

import com.mrdevv.portfolioBackend.models.Proyecto;
import com.mrdevv.portfolioBackend.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseCleaner {

    private final ProyectoRepository proyectoRepository;
    private final ExperienciaRepository experienciaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProfesionalRepository profesionalRepository;

    public void clean() {
        proyectoRepository.deleteAllInBatch();
        experienciaRepository.deleteAllInBatch();
        usuarioRepository.deleteAllInBatch();
        profesionalRepository.deleteAllInBatch();
    }

}

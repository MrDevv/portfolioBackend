package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.dto.projection.ProyectoProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.mappers.ExperienciaMapper;
import com.mrdevv.portfolioBackend.mappers.ProyectoMapper;
import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.ExperienciaRepository;
import com.mrdevv.portfolioBackend.repositories.ProyectoRepository;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProyectoServiceImpl implements IProyectoService {

    private final ProyectoRepository proyectoRepository;
    private final ExperienciaServiceImpl experienciaService;

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerProyectosProfesionalAutenticado(String titulo, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        String tituloLowerCase = titulo != null ? titulo.toLowerCase() : "";
        Page<ProyectoProjectionDTO> proyectosProjection = proyectoRepository.obtenerProyectos(
                profesionalId,
                tituloLowerCase,
                pageable);

        return ProyectoMapper.toResponseProyectoListDTO(proyectosProjection);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerProyectosProfesional(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Page<ProyectoProjectionDTO> proyectosProjection = proyectoRepository.obtenerProyectos(
                profesionalId,
                "",
                pageable);

        return ProyectoMapper.toResponseProyectoListDTO(proyectosProjection);
    }

    @Transactional
    @Override
    public ResponseProyectoDTO crearProyecto(CreateProyectoDTO proyectoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Experiencia experiencia = experienciaService.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, proyectoDTO.experienciaUUID());
        return null;
    }
}

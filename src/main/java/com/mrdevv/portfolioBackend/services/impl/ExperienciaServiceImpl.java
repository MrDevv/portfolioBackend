package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.mappers.ExperienciaMapper;
import com.mrdevv.portfolioBackend.repositories.ExperienciaRepository;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExperienciaServiceImpl implements IExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerExperienciasProfesionalAutenticado(String nombreEmpresa, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        Page<ExperienciaProjectionDTO> experiencias = experienciaRepository.obtenerExperiencias(usuarioId, nombreEmpresa, pageable);
        return ExperienciaMapper.toResponseExperienciasListDTO(experiencias);
    }
}

package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.mappers.ExperienciaMapper;
import com.mrdevv.portfolioBackend.repositories.ExperienciaRepository;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExperienciaServiceImpl implements IExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseExperienciasDTO> obtenerExperiencias() {
        List<ExperienciaProjectionDTO> experiencias = experienciaRepository.obtenerExperiencias();
        return ExperienciaMapper.toResponseExperienciasListDTO(experiencias);
    }
}

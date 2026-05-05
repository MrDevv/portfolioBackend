package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalTecnologiaProjection;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.mappers.ProfesionalTecnologiaMapper;
import com.mrdevv.portfolioBackend.repositories.ProfesionalTecnologiaRepository;
import com.mrdevv.portfolioBackend.services.IProfesionalTecnologiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfesionalTecnologiaImpl implements IProfesionalTecnologiaService {

    private final ProfesionalTecnologiaRepository profesionalTecnologiaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseProfesionalTecnologiaDTO> obtenerTecnologiasProfesionalAutenticado(String nombreTecnologia) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        List<ProfesionalTecnologiaProjection> profesionalTecnologiaProjections = profesionalTecnologiaRepository.obtenerTecnologiasDelProfesional(usuarioId, nombreTecnologia);
        return ProfesionalTecnologiaMapper.toProfesionalTecnologiaDTOList(profesionalTecnologiaProjections);
    }
}

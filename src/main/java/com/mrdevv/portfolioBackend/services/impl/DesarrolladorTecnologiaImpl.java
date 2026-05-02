package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.projection.DesarrolladorTecnologiaProjection;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorTecnologia;
import com.mrdevv.portfolioBackend.mappers.DesarrolladorTecnologiaMapper;
import com.mrdevv.portfolioBackend.models.DesarrolladorTecnologia;
import com.mrdevv.portfolioBackend.repositories.DesarrolladorTecnologiaRepository;
import com.mrdevv.portfolioBackend.services.IDesarrolladorTecnologiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DesarrolladorTecnologiaImpl implements IDesarrolladorTecnologiaService {

    private final DesarrolladorTecnologiaRepository desarrolladorTecnologiaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseDesarrolladorTecnologia> obtenerTecnologiasDesarrollador() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        List<DesarrolladorTecnologiaProjection> desarrolladorTecnologias = desarrolladorTecnologiaRepository.obtenerTecnologiasDelDesarrollador(usuarioId);
        return DesarrolladorTecnologiaMapper.toDesarrolladorTecnologiaDTOList(desarrolladorTecnologias);
    }
}

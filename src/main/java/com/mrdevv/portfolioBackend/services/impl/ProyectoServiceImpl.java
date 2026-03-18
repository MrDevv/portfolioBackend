package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.ProyectoProjectionDTO;
import com.mrdevv.portfolioBackend.mappers.ProyectoMapper;
import com.mrdevv.portfolioBackend.repositories.ProyectoRepository;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProyectoServiceImpl implements IProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerProyectos(Long usuarioId, Pageable pageable) {
        Page<ProyectoProjectionDTO> proyectosProjection = proyectoRepository.obtenerProyectos(
                null,
                usuarioId,
                pageable);

        return ProyectoMapper.toResponseProyectoListDTO(proyectosProjection);
    }
}

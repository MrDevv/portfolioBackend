package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaSimpleDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.TecnologiaMapper;
import com.mrdevv.portfolioBackend.models.Tecnologia;
import com.mrdevv.portfolioBackend.repositories.TecnologiaRepository;
import com.mrdevv.portfolioBackend.services.ITecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TecnologiaServiceImpl implements ITecnologiaService {

    private final TecnologiaRepository tecnologiaRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerTecnologias(String nombre, Pageable pageable) {
        Page<Tecnologia> tecnologias = tecnologiaRepository.obtenerTecnologias(nombre, pageable);
        return TecnologiaMapper.toResponseTecnologiaDTOList(tecnologias);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseTecnologiaDTO obtenerTecnologiaPorUUID(Long tipoProyectoId) {
        Tecnologia tecnologia = tecnologiaRepository.findById(tipoProyectoId).orElseThrow(() -> {
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_TECNOLOGIA_FRONT.getMessage(tipoProyectoId),
                    ErrorMessage.NOT_FOUND_TECNOLOGIA_BACKEND.getMessage(tipoProyectoId)
            );
        });

        return TecnologiaMapper.toResponseTecnologiaDTO(tecnologia);
    }

    @Transactional(readOnly = true)
    @Override
    public Tecnologia obtenerTecnologiaPorUUID(String tecnologiaUUID) {
        return tecnologiaRepository.obtenerTecnologiaPorUUID(tecnologiaUUID).orElseThrow(() -> {
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_TECNOLOGIA_BACKEND.getMessage(tecnologiaUUID),
                    ErrorMessage.NOT_FOUND_TECNOLOGIA_FRONT.getMessage(tecnologiaUUID)
            );
        });
    }
}

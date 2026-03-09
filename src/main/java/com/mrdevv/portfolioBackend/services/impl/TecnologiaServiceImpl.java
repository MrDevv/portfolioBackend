package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.TecnologiaMapper;
import com.mrdevv.portfolioBackend.models.Tecnologia;
import com.mrdevv.portfolioBackend.repositories.TecnologiaRepository;
import com.mrdevv.portfolioBackend.services.ITecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TecnologiaServiceImpl implements ITecnologiaService {

    private final TecnologiaRepository tecnologiaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseTecnologiaDTO> obtenerTecnologias() {
        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();
        return TecnologiaMapper.toResponseTecnologiaDTOList(tecnologias);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseTecnologiaDTO obtenerTecnologiaPorId(Long tipoProyectoId) {
        Tecnologia tecnologia = tecnologiaRepository.findById(tipoProyectoId).orElseThrow(() -> {
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_TECNOLOGIA_FRONT.getMessage(tipoProyectoId),
                    ErrorMessage.NOT_FOUND_TECNOLOGIA_BACKEND.getMessage(tipoProyectoId)
            );
        });

        return TecnologiaMapper.toResponseTecnologiaDTO(tecnologia);
    }
}

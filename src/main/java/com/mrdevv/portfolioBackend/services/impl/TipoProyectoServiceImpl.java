package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.CreateTipoProyecto;
import com.mrdevv.portfolioBackend.dto.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.dto.UpdateTipoProyectoDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.TipoProyectoMapper;
import com.mrdevv.portfolioBackend.models.TipoProyecto;
import com.mrdevv.portfolioBackend.repositories.TipoProyectoRepository;
import com.mrdevv.portfolioBackend.services.ITipoProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TipoProyectoServiceImpl implements ITipoProyectoService {

    private final TipoProyectoRepository tipoProyectoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseTipoProyectoDTO> obtenerTiposProyectos() {
        List<TipoProyecto> tipoProyectos = tipoProyectoRepository.findAll();
        return TipoProyectoMapper.toResponseTipoProyectoDTOList(tipoProyectos);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseTipoProyectoDTO obtenerTipoProyectoPorId(Long tipoProyectoId) {
        TipoProyecto tipoProyecto = tipoProyectoRepository.findById(tipoProyectoId).orElseThrow(() -> {
            throw new ObjectNotFoundException(
                    ErrorMessage.NOT_FOUND_TIPO_PROYECTO_FRONT.getMessage(tipoProyectoId),
                    ErrorMessage.NOT_FOUND_TIPO_PROYECTO_BACKEND.getMessage(tipoProyectoId));
        });

        return TipoProyectoMapper.toResponseTipoProyectoDTO(tipoProyecto);
    }

    @Transactional
    @Override
    public ResponseTipoProyectoDTO crearTipoProyecto(CreateTipoProyecto createTipoProyecto) {
        return null;
    }

    @Transactional
    @Override
    public ResponseTipoProyectoDTO actualizarTipoProyecto(Long tipoProyectoId, UpdateTipoProyectoDTO updateTipoProyecto) {
        return null;
    }
}

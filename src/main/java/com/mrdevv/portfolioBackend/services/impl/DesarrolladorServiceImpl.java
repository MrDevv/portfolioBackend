package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.DesarrolladorMapper;
import com.mrdevv.portfolioBackend.models.Desarrollador;
import com.mrdevv.portfolioBackend.repositories.DesarrolladorRepository;
import com.mrdevv.portfolioBackend.services.IDesarrolladorService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesarrolladorServiceImpl implements IDesarrolladorService {

    private final DesarrolladorRepository desarrolladorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseDesarrolladorDTO> obtenerDesarrolladores() {
        List<Desarrollador> desarrolladores = desarrolladorRepository.findAll();
        return DesarrolladorMapper.toDesarrolladorDTOList(desarrolladores);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseDesarrolladorDTO obtenerDesarrolladorById(Long desarrolladorId) {
        Desarrollador desarrollador = desarrolladorRepository.findById(desarrolladorId).orElseThrow(() -> {
            throw new ObjectNotFoundException(ErrorMessage.NOT_FOUND_DESARROLLADOR_FRONT.getMessage(desarrolladorId),
                    ErrorMessage.NOT_FOUND_DESARROLLADOR_BACKEND.getMessage(desarrolladorId));
        });
        return DesarrolladorMapper.toDesarrolladorDTO(desarrollador);
    }
}

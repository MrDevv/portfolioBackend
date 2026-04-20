package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.projection.DesarrolladorProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateDesarrolladorDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.DesarrolladorMapper;
import com.mrdevv.portfolioBackend.models.Desarrollador;
import com.mrdevv.portfolioBackend.repositories.DesarrolladorRepository;
import com.mrdevv.portfolioBackend.services.IDesarrolladorService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        List<DesarrolladorProjectionDTO> desarrolladores = desarrolladorRepository.obtenerDesarrolladores(usuarioId);
        return DesarrolladorMapper.toDesarrolladorDTOList(desarrolladores);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseDesarrolladorDTO obtenerDatosDesarrollador() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        DesarrolladorProjectionDTO desarrollador = desarrolladorRepository.obtenerDesarrolladorPorId(usuarioId);
        return DesarrolladorMapper.toDesarrolladorDTO(desarrollador);
    }

    @Transactional
    @Override
    public ResponseDesarrolladorDTO actualizarDesarrollador(Long desarrolladorId, UpdateDesarrolladorDTO updateDesarrolladorDTO) {
        Desarrollador desarrollador = buscarDesarrolladorPorId(desarrolladorId);
        DesarrolladorMapper.updateDesarrollador(desarrollador, updateDesarrolladorDTO);
        return DesarrolladorMapper.toDesarrolladorDTO(desarrollador);
    }

    private Desarrollador buscarDesarrolladorPorId(Long desarrolladorId){
        return desarrolladorRepository.findById(desarrolladorId).orElseThrow(() -> {
            throw new ObjectNotFoundException(ErrorMessage.NOT_FOUND_DESARROLLADOR_FRONT.getMessage(desarrolladorId),
                    ErrorMessage.NOT_FOUND_DESARROLLADOR_BACKEND.getMessage(desarrolladorId));
        });
    }
}

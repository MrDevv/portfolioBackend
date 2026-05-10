package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.ProfesionalMapper;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.repositories.ProfesionalRepository;
import com.mrdevv.portfolioBackend.services.IProfesionalService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfesionalServiceImpl implements IProfesionalService {

    private final ProfesionalRepository profesionalRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseProfesionalDTO obtenerDatosProfesionalAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        ProfesionalProjectionDTO profesionalProjectionDTO = profesionalRepository.obtenerDatosProfesionalesPorUsuarioId(usuarioId);
        return ProfesionalMapper.toProfesionalDTO(profesionalProjectionDTO);
    }

    @Transactional
    @Override
    public ResponseProfesionalDTO actualizarProfesionalAutenticado(UpdateProfesionalDTO updateProfesionalDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        Profesional profesional = buscarProfesionalPorId(usuarioId);
        ProfesionalMapper.updateProfesional(profesional, updateProfesionalDTO);
        return ProfesionalMapper.toProfesionalDTO(profesional);
    }

    @Transactional(readOnly = true)
    @Override
    public Profesional obtenerProfesionalPorUsuarioId(Long usuarioId) {
        return profesionalRepository.obtenerProfesionalPorUsuarioId(usuarioId).orElseThrow(() -> {
            throw new ObjectNotFoundException(ErrorMessage.NOT_FOUND_PROFESIONAL_BACKEND.getMessage(), ErrorMessage.NOT_FOUND_USUARIO_BY_EMAIL_FRONT.getMessage());
        });
    }

    private Profesional buscarProfesionalPorId(Long profesionalId){
        return profesionalRepository.findById(profesionalId).orElseThrow(() -> {
            throw new ObjectNotFoundException(ErrorMessage.NOT_FOUND_PROFESIONAL_FRONT.getMessage(profesionalId),
                    ErrorMessage.NOT_FOUND_PROFESIONAL_BACKEND.getMessage(profesionalId));
        });
    }
}

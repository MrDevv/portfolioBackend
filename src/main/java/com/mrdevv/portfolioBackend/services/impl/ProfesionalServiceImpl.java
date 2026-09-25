package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.dto.projection.ProfesionalProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.mappers.ProfesionalMapper;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.Usuario;
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
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        ProfesionalProjectionDTO profesional = profesionalRepository.obtenerDatosProfesionales(profesionalId).orElseThrow(() -> {
            throw new ObjectNotFoundException(ErrorMessage.NOT_FOUND_PROFESIONAL_FRONT.getMessage(profesionalId),
                    ErrorMessage.NOT_FOUND_PROFESIONAL_BACKEND.getMessage(profesionalId));
        });
        return ProfesionalMapper.toProfesionalDTO(profesional);
    }

    @Transactional
    @Override
    public ResponseProfesionalDTO actualizarProfesionalAutenticado(UpdateProfesionalDTO updateProfesionalDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Profesional profesional = buscarProfesionalPorId(profesionalId);
        ProfesionalMapper.updateProfesional(profesional, updateProfesionalDTO);
        return ProfesionalMapper.toProfesionalDTO(profesional);
    }

    @Transactional(readOnly = true)
    @Override
    public Profesional obtenerProfesionalPorId(Long profesionalId) {
        return buscarProfesionalPorId(profesionalId);
    }

    private Profesional buscarProfesionalPorId(Long profesionalId){
        return profesionalRepository.findById(profesionalId).orElseThrow(() -> {
            throw new ObjectNotFoundException(ErrorMessage.NOT_FOUND_PROFESIONAL_FRONT.getMessage(profesionalId),
                    ErrorMessage.NOT_FOUND_PROFESIONAL_BACKEND.getMessage(profesionalId));
        });
    }
}

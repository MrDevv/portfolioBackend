package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.mappers.DesarrolladorMapper;
import com.mrdevv.portfolioBackend.models.Desarrollador;
import com.mrdevv.portfolioBackend.repositories.DesarrolladorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DesarrolladorPublicoServiceImpl implements IDesarrolladorPublicoService{

    private final DesarrolladorRepository desarrolladorRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseDesarrolladorDTO obtenerDatosDesarrollador() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String apiKey = authentication.getPrincipal().toString();
        Desarrollador desarrollador = desarrolladorRepository.obtenerDesarrolladorPorApiKey(apiKey);
        return DesarrolladorMapper.toDesarrolladorDTO(desarrollador);
    }
}

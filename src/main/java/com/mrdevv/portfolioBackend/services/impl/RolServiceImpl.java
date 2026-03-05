package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.exceptions.ObjectInvalidEnumException;
import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.repositories.RolRepository;
import com.mrdevv.portfolioBackend.services.IRolService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import com.mrdevv.portfolioBackend.utils.constants.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RolServiceImpl implements IRolService {

    private final RolRepository rolRepository;

    @Override
    public Rol findRolByDescripcion(Roles descripcion) {
        return rolRepository.buscarRolPorDescripcion(descripcion.name().toLowerCase()).orElseThrow(() -> {
            throw new ObjectInvalidEnumException(
                    ErrorMessage.NOT_FOUND_ROL_FRONT.getMessage(),
                    ErrorMessage.NOT_FOUND_ROL_BACKEND.getMessage());
        });
    }
}

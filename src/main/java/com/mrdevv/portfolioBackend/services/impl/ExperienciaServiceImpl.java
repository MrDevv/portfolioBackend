package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaConProyectosProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateExperienceDTO;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaConProyectosDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.exceptions.ObjectReplicatedException;
import com.mrdevv.portfolioBackend.mappers.ExperienciaMapper;
import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Usuario;
import com.mrdevv.portfolioBackend.repositories.ExperienciaRepository;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExperienciaServiceImpl implements IExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerExperienciasProfesionalAutenticado(String nombreEmpresa, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        String nombreEmpresaLowerCase = nombreEmpresa != null ? nombreEmpresa.toLowerCase() : "";
        Page<ExperienciaProjectionDTO> experiencias = experienciaRepository.obtenerExperiencias(profesionalId, nombreEmpresaLowerCase, pageable);
        return ExperienciaMapper.toResponseExperienciasListDTO(experiencias);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseExperienciaDTO obtenerExperienciaProfesionalAutenticado(String experienciaUUID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Experiencia experiencia = this.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, experienciaUUID);
        return ExperienciaMapper.toResponseExperienciaDTO(experiencia);
    }

    @Transactional(readOnly = true)
    @Override
    public Experiencia obtenerExperienciaPorUUIDyProfesionalId(Long profesionalId, String experienciaUUID) {
        Experiencia experiencia = experienciaRepository.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, experienciaUUID).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_EXPERIENCIA_BACKEND.getMessage(experienciaUUID),
                ErrorMessage.NOT_FOUND_EXPERIENCIA_FRONT.getMessage(experienciaUUID)
        ));
        return experiencia;
    }

    @Transactional
    @Override
    public ResponseExperienciaDTO registrarExperienciaProfesionalAutenticado(CreateExperienciaDTO createExperienciaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        validarExperienciaNoRegistradaPorProfesional(profesionalId, createExperienciaDTO.titulo().trim());
        Experiencia experiencia = experienciaRepository.save(ExperienciaMapper.toExperienciaEntity(createExperienciaDTO, profesionalId));
        return ExperienciaMapper.toResponseExperienciaDTO(experiencia);
    }

    @Transactional
    @Override
    public ResponseExperienciaDTO actualizarExperienciaProfesionalAutenticada(UpdateExperienceDTO updateExperienceDTO, String experienciaUUID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Experiencia experiencia = experienciaRepository.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, experienciaUUID).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_EXPERIENCIA_BACKEND.getMessage(experienciaUUID),
                ErrorMessage.NOT_FOUND_EXPERIENCIA_FRONT.getMessage(experienciaUUID)
        ));
        ExperienciaMapper.actualizarExperienciaEntity(experiencia, updateExperienceDTO);
        return ExperienciaMapper.toResponseExperienciaDTO(experiencia);
    }

    @Transactional
    @Override
    public void eliminarExperienciaProfesionalAutenticado(String experienciaUUID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Experiencia experiencia = experienciaRepository.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, experienciaUUID).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_EXPERIENCIA_BACKEND.getMessage(experienciaUUID),
                ErrorMessage.NOT_FOUND_EXPERIENCIA_FRONT.getMessage(experienciaUUID)
        ));
        experienciaRepository.delete(experiencia);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseExperienciaConProyectosDTO obtenerExperienciaConProyectosProfesionalAutenticado(String experienciaUUID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        ExperienciaConProyectosProjectionDTO experienciaProyectosProjection = experienciaRepository.obtenerDetalleExperiencia(profesionalId, experienciaUUID).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_EXPERIENCIA_BACKEND.getMessage(experienciaUUID),
                ErrorMessage.NOT_FOUND_EXPERIENCIA_FRONT.getMessage(experienciaUUID)
        ));
        return ExperienciaMapper.toResponseExperienciaConProyectosDTO(experienciaProyectosProjection);
    }


    void validarExperienciaNoRegistradaPorProfesional(Long usuarioId, String experienciaTitulo){
        if (experienciaRepository.existeExperienciaEnProfesional(usuarioId, experienciaTitulo)){
            throw new ObjectReplicatedException(
                    ErrorMessage.REPLICATE_OBJECT_EXPERIENCIA_PROFESIONAL_BACKEND.getMessage(experienciaTitulo),
                    ErrorMessage.REPLICATE_OBJECT_EXPERIENCIA_PROFESIONAL_FRONT.getMessage(experienciaTitulo)
            );
        }
    }
}

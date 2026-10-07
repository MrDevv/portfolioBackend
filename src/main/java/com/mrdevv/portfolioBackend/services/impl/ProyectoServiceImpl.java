package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.UsuarioAuthPrincipal;
import com.mrdevv.portfolioBackend.dto.projection.ProyectoProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectNotFoundException;
import com.mrdevv.portfolioBackend.exceptions.ObjectReplicatedException;
import com.mrdevv.portfolioBackend.mappers.ProyectoMapper;
import com.mrdevv.portfolioBackend.models.*;
import com.mrdevv.portfolioBackend.repositories.ProyectoRepository;
import com.mrdevv.portfolioBackend.services.IEtiquetaService;
import com.mrdevv.portfolioBackend.services.IExperienciaService;
import com.mrdevv.portfolioBackend.services.IProyectoService;
import com.mrdevv.portfolioBackend.services.ITipoProyectoService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProyectoServiceImpl implements IProyectoService {

    private final ProyectoRepository proyectoRepository;
    private final IEtiquetaService etiquetaService;
    private final IExperienciaService experienciaService;
    private final ITipoProyectoService tipoProyectoService;

//    Obtiene todos los proyectos del profesional autenticado, con filtros de titulo y paginacion
    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerProyectosProfesionalAutenticado(String titulo, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        String tituloLowerCase = titulo != null ? titulo.toLowerCase() : "";
        Page<ProyectoProjectionDTO> proyectosProjection = proyectoRepository.obtenerProyectos(
                profesionalId,
                tituloLowerCase,
                pageable);

        return ProyectoMapper.toResponseProyectoListDTO(proyectosProjection);
    }

//    Obtiene todos los proyectos del profesional posterior validacion de su API Key, sin filtros
    @Transactional(readOnly = true)
    @Override
    public ResponseWithPageable obtenerProyectosProfesional(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Page<ProyectoProjectionDTO> proyectosProjection = proyectoRepository.obtenerProyectos(
                profesionalId,
                "",
                pageable);

        return ProyectoMapper.toResponseProyectoListDTO(proyectosProjection);
    }

//    Crea un nuevo proyecto para el profesional autenticado, validando que no exista un proyecto con el mismo título en la misma experiencia.
    @Transactional
    @Override
    public ResponseProyectoDTO crearProyecto(CreateProyectoDTO proyectoDTO) {
        List<Etiqueta> etiquetas = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();

        validarProyectoDuplicadoEnExperiencia(proyectoDTO.titulo(), proyectoDTO.experienciaUUID());
        Experiencia experiencia = experienciaService.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, proyectoDTO.experienciaUUID());
        TipoProyecto tipoProyecto = tipoProyectoService.obtenerTipoProyectoPorUUID(proyectoDTO.tipoProyectoUUID());
        if (proyectoDTO.etiquetas() != null) {
            etiquetas = etiquetaService.obtenerEtiquetasPorUUIDs(List.of(proyectoDTO.etiquetas()));
        }
        Proyecto proyecto = ProyectoMapper.toProyectoEntity(proyectoDTO, experiencia, tipoProyecto, etiquetas);
        return ProyectoMapper.toResponseProyectoDTO(proyectoRepository.save(proyecto));
    }

//    Actualizar un proyecto existente del profesional autenticado, validando que no exista un proyecto con el mismo título en la misma experiencia.
    @Transactional
    @Override
    public ResponseProyectoDTO actualizarProyecto(String proyectoUUID, UpdateProyectoDTO proyectoDTO) {
        List<Etiqueta> etiquetas = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Proyecto proyecto = obtenerProyectoPorUUIDyProfesionalId(proyectoUUID, profesionalId);
        if (!proyecto.getTitulo().equalsIgnoreCase(proyectoDTO.titulo())) {
            validarProyectoDuplicadoEnExperiencia(proyectoDTO.titulo(), proyectoDTO.experienciaUUID());
        }
        Experiencia experiencia = experienciaService.obtenerExperienciaPorUUIDyProfesionalId(profesionalId, proyectoDTO.experienciaUUID());
        TipoProyecto tipoProyecto = tipoProyectoService.obtenerTipoProyectoPorUUID(proyectoDTO.tipoProyectoUUID());
        if (proyectoDTO.etiquetas() != null) {
            etiquetas = etiquetaService.obtenerEtiquetasPorUUIDs(List.of(proyectoDTO.etiquetas()));
        }
        ProyectoMapper.actualizarProyecto(proyecto, experiencia, tipoProyecto, etiquetas, proyectoDTO);
        return ProyectoMapper.toResponseProyectoDTO(proyecto);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseProyectoDTO obtenerProyectoPorUUID(String proyectoUUID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        ProyectoProjectionDTO proyectoProjection = proyectoRepository.obtenerProyectoPorUUID(proyectoUUID, profesionalId).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_PROYECTO_BACKEND.getMessage(proyectoUUID),
                ErrorMessage.NOT_FOUND_PROYECTO_FRONT.getMessage(proyectoUUID)
        ));
        return ProyectoMapper.toResponseProyectoDTO(proyectoProjection);
    }

    @Transactional
    @Override
    public void eliminarProyecto(String proyectoUUID) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long profesionalId = ((UsuarioAuthPrincipal) authentication.getPrincipal()).profesionalId();
        Proyecto proyecto = obtenerProyectoPorUUIDyProfesionalId(proyectoUUID, profesionalId);
        proyectoRepository.delete(proyecto);
    }

    //    Valida que no exista un proyecto con el mismo título en la misma experiencia
    private void validarProyectoDuplicadoEnExperiencia(String titulo, String experienciaUUID) {
        boolean existeProyecto = proyectoRepository.existeProyectoEnExperiencia(titulo, experienciaUUID);
        if (existeProyecto) {
            throw new ObjectReplicatedException(
                    ErrorMessage.REPLICATE_OBJECT_PROYECTO_EXPERIENCIA_BACKEND.getMessage(titulo),
                    ErrorMessage.REPLICATE_OBJECT_PROYECTO_EXPERIENCIA_FRONT.getMessage(titulo)
            );
        }
    }

    private Proyecto obtenerProyectoPorUUIDyProfesionalId(String proyectoUUID, Long profesionalId) {
        return proyectoRepository.obtenerProyectoPorUUIDyProfesionalId(proyectoUUID, profesionalId).orElseThrow(() -> new ObjectNotFoundException(
                ErrorMessage.NOT_FOUND_PROYECTO_BACKEND.getMessage(proyectoUUID),
                ErrorMessage.NOT_FOUND_PROYECTO_FRONT.getMessage(proyectoUUID)
        ));
    }
}

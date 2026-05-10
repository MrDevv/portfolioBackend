package com.mrdevv.portfolioBackend.services.impl;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalTecnologiaProjection;
import com.mrdevv.portfolioBackend.dto.request.CreateTecnologiaProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.exceptions.ObjectReplicatedException;
import com.mrdevv.portfolioBackend.mappers.ProfesionalTecnologiaMapper;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.ProfesionalTecnologia;
import com.mrdevv.portfolioBackend.models.Tecnologia;
import com.mrdevv.portfolioBackend.repositories.ProfesionalRepository;
import com.mrdevv.portfolioBackend.repositories.ProfesionalTecnologiaRepository;
import com.mrdevv.portfolioBackend.repositories.TecnologiaRepository;
import com.mrdevv.portfolioBackend.services.IProfesionalTecnologiaService;
import com.mrdevv.portfolioBackend.utils.constants.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfesionalTecnologiaImpl implements IProfesionalTecnologiaService {

    private final ProfesionalTecnologiaRepository profesionalTecnologiaRepository;
    private final TecnologiaServiceImpl tecnologiaService;
    private final ProfesionalServiceImpl profesionalService;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseProfesionalTecnologiaDTO> obtenerTecnologiasProfesionalAutenticado(String nombreTecnologia) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        List<ProfesionalTecnologiaProjection> profesionalTecnologiaProjections = profesionalTecnologiaRepository.obtenerTecnologiasDelProfesional(usuarioId, nombreTecnologia);
        return ProfesionalTecnologiaMapper.toProfesionalTecnologiaDTOList(profesionalTecnologiaProjections);
    }

    @Transactional
    @Override
    public ResponseProfesionalTecnologiaDTO registrarTecnologiaProfesionalAutenticado(CreateTecnologiaProfesionalDTO tecnologiaProfesionalDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long usuarioId = Long.parseLong(authentication.getPrincipal().toString());
        Tecnologia tecnologia = tecnologiaService.obtenerTecnologiaPorUUID(tecnologiaProfesionalDTO.tecnologiaUUID());
        Profesional profesional = profesionalService.obtenerProfesionalPorUsuarioId(usuarioId);
        validarTecnologiaNoRegistradaPorProfesional(profesional, tecnologia);

        ProfesionalTecnologia profesionalTecnologia = profesionalTecnologiaRepository.save(
                ProfesionalTecnologiaMapper.toProfesionalTecnologiaEntity(profesional, tecnologia, tecnologiaProfesionalDTO.nivel())
        );
        return ProfesionalTecnologiaMapper.toProfesionalTecnologiaDTO(profesionalTecnologia);
    }

    void validarTecnologiaNoRegistradaPorProfesional(Profesional profesional, Tecnologia tecnologia){
        if (profesionalTecnologiaRepository.existeTecnologiaProfesional(profesional.getProfesionalId(), tecnologia.getTecnologiaId())){
            throw new ObjectReplicatedException(
                    ErrorMessage.REPLICATE_OBJECT_TECNOLOGIA_PROFESIONAL_BACKEND.getMessage(tecnologia.getTecnologiaUUID()),
                    ErrorMessage.REPLICATE_OBJECT_TECNOLOGIA_PROFESIONAL_FRONT.getMessage(tecnologia.getDescripcion())
            );
        }
    }
}

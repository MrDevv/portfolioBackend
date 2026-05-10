package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalTecnologiaProjection;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import com.mrdevv.portfolioBackend.models.Profesional;
import com.mrdevv.portfolioBackend.models.ProfesionalTecnologia;
import com.mrdevv.portfolioBackend.models.Tecnologia;
import com.mrdevv.portfolioBackend.utils.constants.NivelTecnologia;

import java.util.List;
import java.util.stream.Collectors;

public class ProfesionalTecnologiaMapper {

    public static List<ResponseProfesionalTecnologiaDTO> toProfesionalTecnologiaDTOList(List<ProfesionalTecnologiaProjection> profesionalTecnologiaProjections){
        return profesionalTecnologiaProjections.stream().map(profesionalTecnologiaProjection -> {
            return new ResponseProfesionalTecnologiaDTO(
                    profesionalTecnologiaProjection.getDescripcion(),
                    profesionalTecnologiaProjection.getLogoUrl(),
                    profesionalTecnologiaProjection.getTipoTecnologia(),
                    profesionalTecnologiaProjection.getNivel()
            );
        }).collect(Collectors.toList());
    }

    public static ResponseProfesionalTecnologiaDTO toProfesionalTecnologiaDTO(ProfesionalTecnologia profesionalTecnologiaEntity){
            return new ResponseProfesionalTecnologiaDTO(
                    profesionalTecnologiaEntity.getTecnologia().getDescripcion(),
                    profesionalTecnologiaEntity.getTecnologia().getLogoUrl(),
                    profesionalTecnologiaEntity.getTecnologia().getTipoTecnologia().getDescripcion(),
                    profesionalTecnologiaEntity.getNivel()
            );
    }

    public static ProfesionalTecnologia toProfesionalTecnologiaEntity(Profesional profesional, Tecnologia tecnologia, NivelTecnologia nivelTecnologia){
        return ProfesionalTecnologia.builder()
                .tecnologia(tecnologia)
                .profesional(profesional)
                .nivel(nivelTecnologia != null ? nivelTecnologia.getNivel() : null)
                .build();
    }
}

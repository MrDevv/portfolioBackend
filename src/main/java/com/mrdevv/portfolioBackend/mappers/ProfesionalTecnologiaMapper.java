package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalTecnologiaProjection;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;

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
}

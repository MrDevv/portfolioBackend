package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.DesarrolladorTecnologiaProjection;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorTecnologia;

import java.util.List;
import java.util.stream.Collectors;

public class DesarrolladorTecnologiaMapper {

    public static List<ResponseDesarrolladorTecnologia> toDesarrolladorTecnologiaDTOList(List<DesarrolladorTecnologiaProjection> desarrolladorTecnologiaProjections){
        return desarrolladorTecnologiaProjections.stream().map(desarrolladorTecnologiaProjection -> {
            return new ResponseDesarrolladorTecnologia(
                    desarrolladorTecnologiaProjection.getDescripcion(),
                    desarrolladorTecnologiaProjection.getLogoUrl(),
                    desarrolladorTecnologiaProjection.getTipoTecnologia(),
                    desarrolladorTecnologiaProjection.getNivel()
            );
        }).collect(Collectors.toList());
    }
}

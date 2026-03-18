package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.EtiquetaProjectionDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EtiquetaMapper {

    private EtiquetaMapper(){}

    public static List<ResponseEtiquetaDTO> toEtiquetaListDTO(List<EtiquetaProjectionDTO> etiquetaProjectionDTOS){
        return etiquetaProjectionDTOS.stream().map(etiquetaProjection -> {
            return new ResponseEtiquetaDTO(
                    etiquetaProjection.getEtiquetaId(),
                    etiquetaProjection.getDescripcion()
            );
        }).collect(Collectors.toList());
    }

}

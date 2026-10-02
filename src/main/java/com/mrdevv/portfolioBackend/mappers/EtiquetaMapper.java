package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.EtiquetaProjectionDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;
import com.mrdevv.portfolioBackend.models.Etiqueta;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class EtiquetaMapper {

    private EtiquetaMapper(){}

    public static List<ResponseEtiquetaDTO> toEtiquetaListDTO(List<EtiquetaProjectionDTO> etiquetaProjectionDTOS){
        return etiquetaProjectionDTOS.stream().map(etiquetaProjection -> {
            return new ResponseEtiquetaDTO(
                    etiquetaProjection.getEtiquetaUUID(),
                    etiquetaProjection.getDescripcion()
            );
        }).collect(Collectors.toList());
    }

    public static ResponseWithPageable toEtiquetaListDTO(Page<Etiqueta> etiquetaProjectionDTOS){
        PageableData pageableData = PageableMapper.toPageable(etiquetaProjectionDTOS);

        List<ResponseEtiquetaDTO> etiquetasDTOS = etiquetaProjectionDTOS.getContent().stream().map(etiquetaProjection -> {
            return new ResponseEtiquetaDTO(
                    etiquetaProjection.getEtiquetaUUID(),
                    etiquetaProjection.getDescripcion()
            );
        }).collect(Collectors.toList());

        return new ResponseWithPageable(etiquetasDTOS, pageableData);
    }

    public static List<ResponseEtiquetaDTO> toEtiquetaListDTOFromEntity(List<Etiqueta> etiquetas){
        return etiquetas.stream().map(etiqueta -> {
            return new ResponseEtiquetaDTO(
                    etiqueta.getEtiquetaUUID(),
                    etiqueta.getDescripcion()
            );
        }).collect(Collectors.toList());
    }

}

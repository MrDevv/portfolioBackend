package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaSimpleDTO;
import com.mrdevv.portfolioBackend.models.Tecnologia;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class TecnologiaMapper {

    public static ResponseWithPageable toResponseTecnologiaDTOList(Page<Tecnologia> tecnologias){
        PageableData pageableData = PageableMapper.toPageable(tecnologias);
        List<ResponseTecnologiaDTO> responseTecnologiaDTO = tecnologias.getContent().stream().map(tecnologia -> {
            return new ResponseTecnologiaDTO(
                    tecnologia.getTecnologiaUUID(),
                    tecnologia.getDescripcion(),
                    tecnologia.getLogoUrl(),
                    TipoTecnologiaMapper.toResponseTipoTecnologiaDTO(tecnologia.getTipoTecnologia()));
        }).collect(Collectors.toList());

        return new ResponseWithPageable(responseTecnologiaDTO, pageableData);
    }

    public static ResponseTecnologiaDTO toResponseTecnologiaDTO(Tecnologia tecnologia){
        return new ResponseTecnologiaDTO(
                tecnologia.getTecnologiaUUID(),
                tecnologia.getDescripcion(),
                tecnologia.getLogoUrl(),
                TipoTecnologiaMapper.toResponseTipoTecnologiaDTO(tecnologia.getTipoTecnologia()));
    }

    public static List<ResponseTecnologiaSimpleDTO> toResponseTecnologiaSimpleDTOList(List<Tecnologia> tecnologias){
        return tecnologias.stream().map(tecnologia -> {
            return new ResponseTecnologiaSimpleDTO(
                    tecnologia.getDescripcion(),
                    tecnologia.getLogoUrl(),
                    tecnologia.getTipoTecnologia().getDescripcion());
        }).collect(Collectors.toList());
    }
}

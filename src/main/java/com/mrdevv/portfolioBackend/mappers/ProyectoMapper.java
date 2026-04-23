package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.ProyectoProjectionDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaSimpleDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTipoProyectoDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProyectoMapper {

    private ProyectoMapper(){};

    public static ResponseWithPageable toResponseProyectoListDTO(Page<ProyectoProjectionDTO> proyectoProjectionDTOS){
        List<ProyectoProjectionDTO> proyectoProjectionList =  proyectoProjectionDTOS.getContent();
        PageableData pageableData = PageableMapper.toPageable(proyectoProjectionDTOS);

        List<ResponseProyectoDTO> proyectosListDTO = proyectoProjectionList.stream().map(proyecto -> {
            return new ResponseProyectoDTO(
                proyecto.getProyectoUUID(),
                proyecto.getTitulo(),
                    proyecto.getDescripcion(),
                    proyecto.getUrlProduccion(),
                    proyecto.getUrlRepositorio(),
                    proyecto.getUrlImagenPresentacion(),
                    proyecto.getEstado() ? "activo" : "inactivo",
                    ExperienciaMapper.toResponseExperienciaSimpleDTO(proyecto.getExperiencia()),
                    TipoProyectoMapper.toResponseTipoProyectoDTO(proyecto.getTipoProyecto()),
                    EtiquetaMapper.toEtiquetaListDTO(proyecto.getEtiquetas())
            );
        }).collect(Collectors.toList());

        return new ResponseWithPageable(proyectosListDTO, pageableData);

    }

}

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
            ResponseExperienciaSimpleDTO experienciaSimpleDTO = new ResponseExperienciaSimpleDTO(
                    proyecto.getExperiencia().getExperienciaId(),
                    proyecto.getExperiencia().getDescripcion()
            );

            ResponseTipoProyectoDTO tipoProyectoDTO = new ResponseTipoProyectoDTO(
                    proyecto.getTipoProyecto().getTipoProyectoId(),
                    proyecto.getTipoProyecto().getDescripcion()
            );

            return new ResponseProyectoDTO(
                proyecto.getProyectoId(),
                proyecto.getTitulo(),
                    proyecto.getDescripcion(),
                    proyecto.getUrlProduccion(),
                    proyecto.getUrlRepositorio(),
                    proyecto.getEstado() ? "activo" : "inactivo",
                    ExperienciaMapper.toResponseExperienciaSimpleDTO(proyecto.getExperiencia()),
                    tipoProyectoDTO,
                    EtiquetaMapper.toEtiquetaListDTO(proyecto.getEtiquetas())
            );
        }).collect(Collectors.toList());

        return new ResponseWithPageable(proyectosListDTO, pageableData);

    }

}

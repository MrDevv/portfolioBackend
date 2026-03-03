package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.models.Desarrollador;

import java.util.List;
import java.util.stream.Collectors;

public class DesarrolladorMapper {

    public static ResponseDesarrolladorDTO toDesarrolladorDTO(Desarrollador desarrollador){
        return new ResponseDesarrolladorDTO(desarrollador.getDesarrolladorId(),
                desarrollador.getNombres(),
                desarrollador.getApellidos(),
                desarrollador.getCorreo(),
                desarrollador.getGithubUrl(),
                desarrollador.getLinkedinUrl(),
                desarrollador.getCvUrl(),
                desarrollador.getPrefijoTelefono(),
                desarrollador.getTelefono(),
                desarrollador.getBiografia(),
                desarrollador.getPuesto()
        );
    }

    public static List<ResponseDesarrolladorDTO> toDesarrolladorDTOList(List<Desarrollador> desarrolladores){
        return desarrolladores.stream().map(desarrollador -> {
            return new ResponseDesarrolladorDTO(desarrollador.getDesarrolladorId(),
                    desarrollador.getNombres(),
                    desarrollador.getApellidos(),
                    desarrollador.getCorreo(),
                    desarrollador.getGithubUrl(),
                    desarrollador.getLinkedinUrl(),
                    desarrollador.getCvUrl(),
                    desarrollador.getPrefijoTelefono(),
                    desarrollador.getTelefono(),
                    desarrollador.getBiografia(),
                    desarrollador.getPuesto()
            );
        }).collect(Collectors.toList());
    }

}

package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.models.Profesional;

public class ProfesionalMapper {

    public static ResponseProfesionalDTO toProfesionalDTO(ProfesionalProjectionDTO profesionalProjection){
        return new ResponseProfesionalDTO(
                profesionalProjection.getProfesionalUUID(),
                profesionalProjection.getNombres(),
                profesionalProjection.getApellidos(),
                profesionalProjection.getCorreoContacto(),
                profesionalProjection.getGithubUrl(),
                profesionalProjection.getLinkedinUrl(),
                profesionalProjection.getCvUrl(),
                profesionalProjection.getLogoUrl(),
                profesionalProjection.getPrefijoTelefono(),
                profesionalProjection.getTelefono(),
                profesionalProjection.getBiografia(),
                profesionalProjection.getPuesto()
        );
    }

    public static ResponseProfesionalDTO toProfesionalDTO(Profesional profesional){
        return new ResponseProfesionalDTO(
                profesional.getProfesionalUUID(),
                profesional.getNombres(),
                profesional.getApellidos(),
                profesional.getCorreoContacto(),
                profesional.getGithubUrl(),
                profesional.getLinkedinUrl(),
                profesional.getCvUrl(),
                profesional.getLogoUrl(),
                profesional.getPrefijoTelefono(),
                profesional.getTelefono(),
                profesional.getBiografia(),
                profesional.getPuesto()
        );
    }

    public static void updateProfesional(Profesional profesional, UpdateProfesionalDTO updateProfesionalDTO){
        profesional.setNombres(updateProfesionalDTO.nombres());
        profesional.setApellidos(updateProfesionalDTO.apellidos());
        profesional.setCorreoContacto(updateProfesionalDTO.correoContacto());
        profesional.setGithubUrl(updateProfesionalDTO.githubUrl());
        profesional.setCvUrl(updateProfesionalDTO.cvUrl());
        profesional.setLogoUrl(updateProfesionalDTO.logoUrl());
        profesional.setPrefijoTelefono(updateProfesionalDTO.prefijoTelefono());
        profesional.setTelefono(updateProfesionalDTO.telefono());
        profesional.setBiografia(updateProfesionalDTO.biografia());
        profesional.setPuesto(updateProfesionalDTO.puesto());
    }

}

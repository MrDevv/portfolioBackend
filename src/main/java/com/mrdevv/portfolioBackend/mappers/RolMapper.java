package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.ResponseRolDTO;
import com.mrdevv.portfolioBackend.models.Rol;

public class RolMapper {

    public static ResponseRolDTO toResponseRolDTO(Rol rol){
        return new ResponseRolDTO(rol.getRolId(), rol.getDescripcion());
    }
}

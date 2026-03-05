package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.models.Rol;
import com.mrdevv.portfolioBackend.utils.constants.Roles;

public interface IRolService {

    Rol findRolByDescripcion(Roles descripcion);

}

package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateRolUsuarioDTO;
import com.mrdevv.portfolioBackend.models.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<ResponseUsuarioDTO> obtenerUsuarios();

    void actualizarRol(Long usuarioId, UpdateRolUsuarioDTO rol);

    ResponseApiKeyUsuario generarApiKey(Long usuarioId);
}
